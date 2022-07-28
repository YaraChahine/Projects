#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define numberOfFiles 21

static char * fileNames[numberOfFiles] = {"file0.txt", "file1.txt" , "file2.txt","file3.txt","file4.txt","file5.txt","file6.txt",
"file7.txt", "file8.txt" , "file9.txt","file10.txt","file11.txt","file12.txt","file13.txt",
"file14.txt", "file15.txt" , "file16.txt","file17.txt","file18.txt","file19.txt","file20.txt"}; //list of files

static int palindromes[numberOfFiles] = { 0 }; //used to save palindrome count for every file

void print_palindromes() { //print palindromes
    for(int i=0; i<numberOfFiles; i++)
        printf("%s: %d\n", fileNames[i], palindromes[i]);
}

int isPalindrome(char *string){ //check if palindrome
    int result=0;
    for(int i=0;i<strlen(string)/2;i++){
        if(string[i]!=string[strlen(string)-i-1]){
            result++;
            break;
        }
    }
    if(result == 0){
        return 1; //return 1 if palindrome
    }
    return 0;//return 1 if palindrome
}

int main(int argc, char** argv) {
    MPI_Init(&argc, &argv);

    int rank, world_size;

    MPI_Comm_rank(MPI_COMM_WORLD, &rank); //get rank
    MPI_Comm_size(MPI_COMM_WORLD, &world_size); //get total number of processes

    MPI_Barrier(MPI_COMM_WORLD);
    double start_time = MPI_Wtime(); //start time

    if(world_size==1){ //if we have only 1 process, there won't be any workers. It will compute serially.
        for(int i=0;i<numberOfFiles;i++){
            FILE* file = fopen(fileNames[i], "r");
            char* totalString = (char*) malloc(sizeof(char) * 1000000); //assume total characters in file is less than 1000000
            char* line = (char*) malloc(sizeof(char) * 1000); //assume each line has less than 1000000 characters
            while (fgets(line, 1000, file)) {
                strcat(totalString, line); //add each line of the file to the total string
            }
            fclose(file);
            char **words = (char**) malloc(sizeof(char) * (10000000)); //more memory needed for null terminating chars of each word in totalString
            int wordCount = 0;
            char *word = strtok(totalString, " "); //split whole text into words by space
            while (word != NULL) {
                words[wordCount] = word;
                word = strtok(NULL, " ");
                wordCount++; //keep track of number of words, which represents array size
            }
            int palindromeCount = 0;
            for(int j=0;j<wordCount;j++){
                if(isPalindrome(words[j])==1){ //check if each word in the file is a palindrome
                    palindromeCount++;
                }
            }
            palindromes[i]=palindromeCount;
        }
    }else{
        int flag = -1; //initialize termination flag
        if (rank==0){ //master process, used to distribute tasks
            int * task_map = (int*) malloc(sizeof(int) * world_size); //save index of task being sent depending on process rank
            for(int i=0; i<world_size; i++) {
                task_map[i] = -1;
            }
            int next_task = 0;
            int next_process = 1;
            int task_completed = 0;
            while(next_process<world_size && next_task < numberOfFiles){ //if we have more processes and tasks
                MPI_Send(&next_task, 1, MPI_INT, next_process, 0, MPI_COMM_WORLD); //send task and do the necessary changes to the variables
                task_map[next_process] = next_task;
                next_process++;
                next_task++;
            }
            while(task_completed < numberOfFiles){ //as long as we have uncompleted tasks
                MPI_Status status;
                int task_result;
                MPI_Recv(&task_result, 1, MPI_INT, MPI_ANY_SOURCE, 1, MPI_COMM_WORLD, &status); //receive result
                int sender = status.MPI_SOURCE; //used to get rank of the process that sent the task
                int task_index = task_map[sender];
                palindromes[task_index] = task_result; //update palindromes array
                task_completed++;
                if(next_task<numberOfFiles){ //if we have more tasks, master process sends more tasks to the processes that currently have no tasks
                    MPI_Send(&next_task, 1, MPI_INT, sender, 0, MPI_COMM_WORLD);
                    task_map[sender] = next_task;
                    next_task++;
                }else{
                    MPI_Send(&flag, 1, MPI_INT, sender, 0, MPI_COMM_WORLD); //if all tasks have been assigned, send a termination flag
                }
            }
        }else{
            while(1){ //worker processes will keep on receiving tasks
                int number;
                MPI_Recv(&number, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
                if(number==flag){ //if the task received is the termination flag, break out of the loop (terminate)
                    break;
                }
                FILE* file = fopen(fileNames[number], "r");
                char* totalString = (char*) malloc(sizeof(char) * 1000000);;
                char* line = (char*) malloc(sizeof(char) * 1000);
                while (fgets(line, 1000, file)) {
                    strcat(totalString, line);
                }
                fclose(file);
                char **words = (char**) malloc(sizeof(char) * (10000000));
                int wordCount = 0;
                char *word = strtok(totalString, " ");
                while (word != NULL) {
                    words[wordCount] = word;
                    word = strtok(NULL, " ");
                    wordCount++;
                }
                int palindromeCount = 0;
                for(int j=0;j<wordCount;j++){
                    if(isPalindrome(words[j])==1){
                    palindromeCount++;
                    }
                }
                MPI_Send(&palindromeCount, 1, MPI_INT, 0, 1, MPI_COMM_WORLD); //send result to master process
            }
        }
    }
    MPI_Barrier(MPI_COMM_WORLD); //wait for all processes to finish before printing time
    double end_time = MPI_Wtime();

    if(rank == 0) {
        printf("Total time: %fs\n",end_time-start_time);
        print_palindromes();
    }
    MPI_Finalize();
}
