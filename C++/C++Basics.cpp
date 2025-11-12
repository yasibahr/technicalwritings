#include <iostream>
#include <vector>
using namespace std;

// Function declarations
int addNumbers(int a, int b);
void greetUser(string name);

int main() {
    cout << "=== C++ Basics Demo ===\n";

    // Variables
    int number = 10;
    double price = 19.99;
    bool isCppFun = true;
    string message = "Hello, C++!";

    cout << number << " " << price << " " << isCppFun << endl;
    cout << message << endl;

    // Input
    string name;
    cout << "\nEnter your name: ";
    cin >> name;
    cout << "Nice to meet you, " << name << "!" << endl;

    // Vector (like ArrayList)
    vector<string> fruits = {"Apple", "Banana", "Cherry"};
    cout << "\nFruits list:\n";
    for (auto &fruit : fruits)
        cout << fruit << endl;

    // Loops
    cout << "\nFor loop:\n";
    for (int i = 0; i < 5; i++) cout << i << endl;

    cout << "\nWhile loop:\n";
    int counter = 0;
    while (counter < 3) { cout << counter << endl; counter++; }

    // Do-while loop
    cout << "\nDo-while loop:\n";
    int j = 0;
    do { cout << j << endl; j++; } while (j < 2);

    // Conditional
    int age = 20;
    if (age >= 18) cout << "You are an adult.\n";
    else cout << "You are not an adult yet.\n";

    // Functions
    int sum = addNumbers(5, 7);
    cout << "\nSum of 5 and 7: " << sum << endl;
    greetUser(name);

    return 0;
}

int addNumbers(int a, int b) { return a + b; }
void greetUser(string name) { cout << "Hello again, " << name << "!\n"; }
