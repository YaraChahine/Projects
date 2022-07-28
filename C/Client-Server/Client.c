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
#include <stdbool.h>
#include <wait.h>
#include <signal.h>

#define PORT 8224  //choose port number

int main(int argc,char* argv[])
{
  while(1){ //keep taking commands from client
  int sock = 0; //client socket used to communicate with the server
  struct sockaddr_in serv_addr;
  if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0){ //create a socket with the specified domain and protocol
    printf("\n Socket creation error \n");
    return -1;
  }

  serv_addr.sin_family = AF_INET;  //set domain
  serv_addr.sin_port = htons(PORT); //set port number

  if (inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr) <= 0){ //convert address  and set IP
    printf("\nInvalid address/ Address not supported \n");
    return -1;
  }

  if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {  //attempt to make a connection on the socket
    printf("\nConnection Failed \n");
    return -1;
  }
char input[1024]={0};
fgets(input,sizeof(input),stdin);//gets input from user
if(input[strlen(input)-1]=='\n'){   //removes empty space
	input[strlen(input)-1]='\0';
}
send(sock,input,strlen(input),0); //sends input to server
char result[5000]={0};
printf("Input Sent\n");
read(sock, result, 5000); //read output/result from server
printf("Result received\n");
printf("%s\n", result);
close(sock); //close socket
}
return 0;
}
