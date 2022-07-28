#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define numberOfFiles 21

static char * fileNames[numberOfFiles] = {"file0.txt", "file1.txt" , "file2.txt","file3.txt","file4.txt","file5.txt","file6.txt",
"file7.txt", "file8.txt" , "file9.txt","file10.txt","file11.txt","file12.txt","file13.txt",
"file14.txt", "file15.txt" , "file16.txt","file17.txt","file18.txt","file19.txt","file20.txt"};

static int palindromes[numberOfFiles] = { 0 };

int isPalindrome(char *string){
    int result=0;
    for(int i=0;i<strlen(string)/2;i++){
        if(string[i]!=string[strlen(string)-i-1]){
            result++;
            break;
        }
    }
    if(result == 0){
        return 1;
    }
    return 0;
}
int main(int argc, char** argv) {
    MPI_Init(&argc, &argv);

    int rank;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    double start_time = MPI_Wtime();

    if(rank == 0){ //serial computation of checking palindrome counts, similar comments to those in ProjectDynamic.c
        for(int i=0;i<numberOfFiles;i++){
            FILE* file = fopen(fileNames[i], "r");
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
            palindromes[i]=palindromeCount;
        }
    }
    void print_palindromes() {
        for(int i=0; i<numberOfFiles; i++)
            printf("%s: %d\n", fileNames[i], palindromes[i]);
    }
    double end_time = MPI_Wtime();
    printf("Total time: %fs\n",end_time-start_time);
    print_palindromes();
}
