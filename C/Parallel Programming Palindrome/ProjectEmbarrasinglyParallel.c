#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define numberOfFiles 21

static char * fileNames[numberOfFiles] = {"file0.txt", "file1.txt" , "file2.txt","file3.txt","file4.txt","file5.txt","file6.txt",
"file7.txt", "file8.txt" , "file9.txt","file10.txt","file11.txt","file12.txt","file13.txt",
"file14.txt", "file15.txt" , "file16.txt","file17.txt","file18.txt","file19.txt","file20.txt"};
static int palindromes[numberOfFiles] = { 0 }; //some comments are not added as they are similar to those in ProjectDynamic.c
void print_palindromes() {
  for(int i=0; i<numberOfFiles; i++)
    printf("%s: %d\n", fileNames[i], palindromes[i]);
}
int isPalindrome(char *string){
    int result=0;
    for(int i=0;i<strlen(string)/2;i++){
        if(string[i]!=string[strlen(string)-i-1]){
            result++;
        }
    }
    if(result == 0){
        return 1;
    }
    return 0;
}

int main(int argc, char** argv) {
  MPI_Init(&argc, &argv);

  int rank, world_size;
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &world_size);

  MPI_Barrier(MPI_COMM_WORLD);
  double start_time = MPI_Wtime();

  int files_per_processes = numberOfFiles / world_size; //get number of files for each process to handle
  int remainder = numberOfFiles % world_size; //get any files left to give them to the last process
  if(rank==0){
    int low = rank * files_per_processes; //calculate low and high to know which files to handle
    int high = low + files_per_processes;
  for(int i=low; i<high; i++) {
    FILE* file = fopen(fileNames[i], "r");
    char* totalString = (char*) malloc(sizeof(char) * 100000000);;
    char* line = (char*) malloc(sizeof(char) * 100000);
    while (fgets(line, 1000, file)) {
        strcat(totalString, line);
    }
    fclose(file);
    char **words = (char**) malloc(sizeof(char) * (1000000000));
    int wordCount = 0;
    char *word = strtok(totalString, " ");
    while (word != NULL) {
        words[wordCount] = word;
        word = strtok(NULL, " ");
        wordCount++;
    }
    int palindromeCount = 0;
    for(int i=0;i<wordCount;i++){
        if(isPalindrome(words[i])==1){
            palindromeCount++;
        }
    }
    palindromes[i]=palindromeCount;
    }
    for(int i=1;i<world_size;i++){ //process 0 receives tasks from the other processes
         if(i==world_size-1){  //if it is receiving from the last process, it might receive additional data depending on remainder
             MPI_Recv(palindromes + i*files_per_processes,files_per_processes+remainder,MPI_INT,i,1,MPI_COMM_WORLD,NULL);
         }else{
             MPI_Recv(palindromes + i*files_per_processes,files_per_processes,MPI_INT,i,1,MPI_COMM_WORLD,NULL);
         }
    }
  }
  if(rank>0){
    int high;
    int low = rank * files_per_processes;
    if(rank==world_size-1){
        high = low + files_per_processes + remainder;
    }else{
        high = low + files_per_processes;
    }
    for(int i=low; i<high; i++) {
        FILE* file = fopen(fileNames[i], "r");
        char* totalString = (char*) malloc(sizeof(char) * 100000000);;
        char* line = (char*) malloc(sizeof(char) * 100000);
        while (fgets(line, 1000, file)) {
            strcat(totalString, line);
        }
        fclose(file);
        char **words = (char**) malloc(sizeof(char) * (1000000000));
        int wordCount = 0;
        char *word = strtok(totalString, " ");
        while (word != NULL) {
            words[wordCount] = word;
            word = strtok(NULL, " ");
            wordCount++;
        }
        int palindromeCount = 0;
        for(int i=0;i<wordCount;i++){
            if(isPalindrome(words[i])==1){
                palindromeCount++;
            }
        }
       palindromes[i]=palindromeCount;
    }
    if(rank==world_size-1){ //send results to process 0. if it is the last process, it might send extra results depending on remainder
        MPI_Send(palindromes + low, files_per_processes+remainder, MPI_INT, 0, 1, MPI_COMM_WORLD);
    }else{
        MPI_Send(palindromes + low, files_per_processes, MPI_INT, 0, 1, MPI_COMM_WORLD);
    }
  }

  MPI_Barrier(MPI_COMM_WORLD);
  double end_time = MPI_Wtime();

  if(rank == 0) {
    print_palindromes();
    printf("Total time: %fs\n",end_time-start_time);
  }

  MPI_Finalize();
}
