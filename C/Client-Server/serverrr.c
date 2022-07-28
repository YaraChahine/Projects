#include <unistd.h>
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/types.h>
#include <pthread.h>
#include <wait.h>
#include <signal.h>

#define PORT 8224  //choose port number
//Our features:
//Forks:ls -l,ls,cp,mv,rm,wc,pwd,find,rmdir,mkdir
//Pipes:ls -l|wc, mkdir|ls|wc, rmdir|rmdir|ls|sort
//Input example: mkdir directoryName|ls|wc
void* ThreadFunction(void *);  //call thread function
int main(int argc,char* argv[])
{
  int sock1, sock3; //sock1:server socket used to listen and accept incoming connections, sock2:client socket used to communicate with a connected client
  struct sockaddr_in address; //a struct that holds information about internet address
  int addrlen = sizeof(address);
  if ((sock1 = socket(AF_INET, SOCK_STREAM, 0)) == 0) { //create server socket
    perror("socket failed");
    exit(EXIT_FAILURE);
  }

  address.sin_family = AF_INET; //set domain
  address.sin_addr.s_addr = INADDR_ANY; //set IP
  address.sin_port = htons(PORT); //set port number

  if (bind(sock1, (struct sockaddr *)&address, sizeof(address)) < 0){ //attach socket to port
    perror("bind failed");
    exit(EXIT_FAILURE);
  }
while (1){ //keep listening for connections
    if (listen(sock1, 5) < 0){ //mark socket to accept connection requests with a maximum of size of 3 pending connectiong queue
      perror("Listen Failed");
      exit(EXIT_FAILURE);
    }
    if ((sock3 = accept(sock1, (struct sockaddr *)&address,(socklen_t *)&addrlen)) < 0){ //accept connection
      perror("accept");
      exit(EXIT_FAILURE);
    }
    pthread_t th; //initialize thread
    pthread_attr_t attr;
    pthread_attr_init(&attr); //give the thread an attribute
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED); //make the thread detachable for better performance
    pthread_create(&th,&attr,ThreadFunction,&sock3); //create thread 
}
close(sock1);
return 0;
}
void* ThreadFunction(void * param){  //common function for all threads
int *sock = (int*) param;
int sock2 = *sock;
char input[1024] = {0};
int numberOfPipes=0;
recv(sock2, input, sizeof(input),0);
printf("Input received %s\n",input);
for(int i=0;i<strlen(input);i++){ //checks number of pipes
	if(input[i]=='|')
        	numberOfPipes++;
}
if(numberOfPipes==0){
	int spaceCount=1;
	for(int i=0;i<strlen(input);i++){ //checks size of array
        	if(input[i]==' ')
               		spaceCount++;
	}
        int i = 0;			//splits at " "
        char *p = strtok (input, " ");
        char *array[spaceCount];
        while (p != NULL){
    		array[i++] = p;
   		p = strtok (NULL, " ");
        }
	int length=strlen(array[0]);
	pid_t pid;			//forks
	pid=fork();
	if(pid<0){			//in case of error
 		printf("Error in forking");
    		exit(EXIT_FAILURE);
	}
	if(pid>0){  			//parent
		wait(NULL);
	}
	if(length==2){			//the following code checks length of command and the type of it, then executes
		if(pid==0){
			if (strcmp(array[0],"ls")==0 && strcmp(array[1],"-l")==0){
				array[0]="ls";
				array[1]="-l";
				array[2]=".";
				array[3]=NULL;
				dup2(sock2,1); //redirecting result to client
 		        	if((execvp("ls", array)) < 0) {
                                	perror("Execvp failed from child");
				}
	       		}
	       		if (strcmp(array[0],"ls")==0){
 	      	        	array[1]=NULL;
				dup2(sock2,1);
                        	if((execvp("ls", array)) < 0) {
                             	        perror("Execvp failed from child");
                        	}
	      	        }
		        if (strcmp(array[0],"cp")==0){
				array[3]=NULL;
				dup2(sock2,1);
         		        if((execvp("cp", array)) < 0) {
                                        perror("Execvp failed from child");
                        	}
               		}
  	       	        if (strcmp(array[0],"mv")==0){
				array[3]=NULL;
			        dup2(sock2,1);
	                     	if((execvp("mv", array)) < 0) {
                                	perror("Execvp failed from child");
}
               		}
   	       	        if (strcmp(array[0],"rm")==0){
               	       		char* exp[]={array[0],array[1],NULL};
				dup2(sock2,1);
               			if((execvp("rm", exp)) < 0) {
      					perror("Execvp failed from child");
	       			}
               		}
  	       	        if (strcmp(array[0],"wc")==0){
				array[1]=NULL;
				dup2(sock2,1);
                        	if((execvp("wc", array)) < 0) {
                                	perror("Execvp failed from child");
                        	}
	       	       }
		}
	}
	if(length==3){
		if(pid==0){
			array[1]=NULL;
			dup2(sock2,1);
            		if((execvp("pwd", array)) < 0) {
                                perror("Execvp failed from child");
                        }

		}
	}
	if(length==4){
		if(pid==0){
			if (strcmp(array[0],"sort")==0){
                                array[1]=NULL;
                                dup2(sock2,1);
                                if((execvp("sort", array)) < 0) {
                                        perror("Execvp failed from child");
                                }
                       }
			if (strcmp(array[0],"find")==0){
				char* exp[]={array[0],array[1],NULL};
            			dup2(sock2,1);
				if((execvp("find", exp)) < 0) {
                                	perror("Execvp failed from child");
                  	     	}
			}

		}
	}
	if(length==5){
		if(pid==0){
    			if (strcmp(array[0],"rmdir")==0){
    				char* exp[]={array[0],array[1],NULL};
				dup2(sock2,1);
            			if((execvp("rmdir", exp)) < 0) {
                                	perror("Execvp failed from child");
                        	}
			}
    			if (strcmp(array[0],"mkdir")==0){
				char* exp[]={array[0],array[1],NULL};
				dup2(sock2,1);
				if((execvp("mkdir", exp)) < 0) {
                        	        perror("Execvp failed from child");
                       		 }
			}
		}
	}
}
else if(numberOfPipes==1){		//the next 3 codes check the number of pipes, split the input then execute the commands in the children
	char * token1 = strtok(input, "|");
        char * allString = token1;
        token1 = strtok(NULL, "");
        char * token4 = strtok(token1, " ");
        char * string3 = token4;
        token4 = strtok(NULL," ");
        char * string4 = token4;
        char * token3 = strtok(allString, " ");
        char * string1 = token3;
        token3= strtok(NULL, " ");
        char * string2 = token3;
  	pid_t pids[2];
   	int fd[2];
   	pipe(fd);
    	for(int i=0;i<2;i++){
        	pids[i] = fork();
        	if(pids[i] == 0){
              		if(i==0){
			 	 dup2(fd[1],1); //close sdout and redirec>
                                 close(fd[0]);
                                 close(fd[1]);
                                 char * exp[]={string1,string2,NULL};
                                 if((execvp(string1, exp)) < 0) {
                                        perror("Execvp failed from child");
                                 }
                                 exit(0);
                        }
                        if(i==1){
                                dup2(fd[0],0); //close stdin and redirect>
				dup2(sock2,1);
                                close(fd[0]);
                                close(fd[1]);
                                char * exp[]={string3,string4,NULL};
                                if((execvp(string3, exp)) < 0) {
                                        perror("Execvp failed from child");
                                }
                                exit(0);
                                }
                        }
                }
 close(fd[0]);
 close(fd[1]);
}
else if(numberOfPipes==2){
	char * token1 = strtok(input, "|");
        char * allString = token1;
        char * token2=strtok(NULL,"|");
        char * allString2= token2;
        char * token5=strtok(NULL,"|");
        char * allString3 = token5;
        char * token7 = strtok(allString3," ");
        char * string5 = token7;
        token7=strtok(NULL," ");
        char * string6 = token7;
        char * token8 = strtok(allString2," ");
        char * string3 = token8;
        token8=strtok(NULL," ");
        char * string4 = token8;
        token1 = strtok(NULL, " ");
        char * token3 = strtok(allString, " ");
        char * string1 = token3;
        token3= strtok(NULL, " ");
        char * string2 = token3;

   	pid_t pidss[3];
   	int fd[2];
   	int fd2[2];
   	pipe(fd);
   	pipe(fd2);
   	for(int i=0;i<3;i++){
      		pidss[i] = fork();
      		if(pidss[i] == 0){ 
          		if(i==0){
            			dup2(fd[1],1);
            			close(fd[0]);
            			close(fd[1]);
           			char * exp[]={string1,string2,NULL};
               				if((execvp(string1, exp)) < 0) {
                                		perror("Execvp failed from child");
                        		}
            			exit(0);
        			}
        		if(i==1){
            			dup2(fd[0],0);
           			dup2(fd2[1],1);
        		        close(fd[0]);
      		     	        close(fd[1]);
       				close(fd2[0]);
            			close(fd2[1]);
            			char * exp[]={string3,string4,NULL};
             				 if((execvp(string3, exp)) < 0) {
                                		perror("Execvp failed from child");
                       			 }
            			exit(0);
         			}
            		close(fd[0]);
            		close(fd[1]);
            		if(i==2){
            			dup2(fd2[0],0);
				dup2(sock2,1);
           	 		close(fd2[0]);
            			close(fd2[1]);
            			char * exp[]={string5,string6,NULL};
               				if((execvp(string5,exp)) < 0) {
                                		perror("Execvp failed from child");
                        		}
           			 exit(0);
         		}
     		}
	}
	close(fd[0]);
        close(fd[1]);
	close(fd2[0]);
        close(fd2[1]);

}
else if(numberOfPipes==3){
	char * token1 = strtok(input, "|");
        char * allString = token1;
        char * token2=strtok(NULL,"|");
        char * allString2= token2;
        char * token5=strtok(NULL,"|");
        char * allString3 = token5;
        char * token6=strtok(NULL,"|");
        char * allString4 = token6;
        token1 = strtok(allString4," ");
        char * string7 = token1;
        token1=strtok(NULL," ");
        char * string8 = token1;
        char * token7 = strtok(allString3," ");
        char * string5 = token7;
        token7=strtok(NULL," ");
        char * string6 = token7;
        char * token8 = strtok(allString2," ");
        char * string3 = token8;
        token8=strtok(NULL," ");
        char * string4 = token8;
        token1 = strtok(NULL, " ");
        char * token3 = strtok(allString, " ");
        char * string1 = token3;
        token3= strtok(NULL, " ");
        char * string2 = token3;
  	pid_t pidsss[4];
   	int fd[2];
   	int fd2[2];
  	int fd3[2];
   	pipe(fd);
   	pipe(fd2);
   	pipe(fd3);
   	for(int i=0;i<4;i++){
      		pidsss[i] = fork();
      		if(pidsss[i] == 0){ 
          		if(i==0){
            			dup2(fd[1],1);
            			close(fd[0]);
            			close(fd[1]);
           			char * exp[]={string1,string2,NULL};
               			if((execvp(string1, exp)) < 0) {
                               		perror("Execvp failed from child");
                        	}
            			exit(0);
			}
           		 if(i==1){
           			 dup2(fd[0],0);
            		   	 dup2(fd2[1],1);
            			 close(fd[0]);
           			 close(fd[1]);
            			 close(fd2[0]);
            			 close(fd2[1]);
            			 char * exp[]={string3,string4,NULL};
             			 if((execvp(string3, exp)) < 0) {
                                	perror("Execvp failed from child");
                        	 }
            			 exit(0);
         		}
            		close(fd[0]);
            		close(fd[1]);
            		if(i==2){
            			dup2(fd2[0],0);
            			dup2(fd3[1],1);
           			close(fd2[0]);
            			close(fd2[1]);
 	    			close(fd3[0]); 
            			close(fd3[1]);
            			char * exp[]={string5,string6,NULL};
             			if((execvp(string5, exp)) < 0) {
                                	perror("Execvp failed from child");
                        	}
            			exit(0);
         		}
         		close(fd2[0]);
        		close(fd2[1]);
			if(i==3){
				dup2(fd3[0],0);
 				dup2(sock2,1);
				close(fd3[0]);
				close(fd3[1]);
				char * exp[]={string7,string8,NULL};
         			if((execvp(string7, exp)) < 0) {
                               		perror("Execvp failed from child");
                        	}
       				exit(0);
			}
		}
	}
  close(fd[0]);
  close(fd[1]);
  close(fd2[0]);
  close(fd2[1]);
  close(fd3[0]);
  close(fd3[1]);
}
close(sock2);
}
