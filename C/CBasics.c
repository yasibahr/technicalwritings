#include <stdio.h>
#include <string.h>

// Function declarations
int addNumbers(int a, int b);
void greetUser(char name[]);

int main() {
    printf("=== C Basics Demo ===\n");

    // Variables
    int number = 10;
    double price = 19.99;
    int isCFun = 1; // boolean in C is int
    char message[] = "Hello, C!";
    printf("%d %.2f %d\n", number, price, isCFun);
    printf("%s\n", message);

    // Input
    char name[50];
    printf("\nEnter your name: ");
    scanf("%49s", name); // limit input size
    printf("Nice to meet you, %s!\n", name);

    // Array
    char* fruits[] = {"Apple", "Banana", "Cherry"};
    printf("\nFruits list:\n");
    for (int i=0;i<3;i++) printf("%s\n", fruits[i]);

    // Loops
    printf("\nFor loop:\n");
    for(int i=0;i<5;i++) printf("%d\n", i);

    printf("\nWhile loop:\n");
    int counter = 0;
    while(counter<3){ printf("%d\n", counter); counter++; }

    // Do-while loop
    printf("\nDo-while loop:\n");
    int j=0;
    do { printf("%d\n", j); j++; } while(j<2);

    // Conditional
    int age = 20;
    if(age >= 18) printf("You are an adult.\n");
    else printf("You are not an adult yet.\n");

    // Functions
    int sum = addNumbers(5,7);
    printf("\nSum of 5 and 7: %d\n", sum);
    greetUser(name);

    return 0;
}

int addNumbers(int a, int b){ return a + b; }
void greetUser(char name[]){ printf("Hello again, %s!\n", name); }
