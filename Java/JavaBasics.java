//Import classes for input and lists 
import java.util.ArrayList; 
import java.util.Scanner; 

public class JavaBasics {
    public static void main(String[] args) { //main method 
        
        /*VARIABLES and DATATYPES*/
        System.out.println("\n****VARIABLES and DATATYPES****");
        int number = 10;
        double price = 19.99;
        boolean yes = true;
        String food = "bananas";

        System.out.print("I have " + food);
        System.out.print("\nI have " + number + " of them");
        System.out.print("\nAre bananas yellow?: " + yes);
        System.out.print("\n" + number + " " + food + " cost $" + price + "\n");  
        
        /*USER INPUTS*/
        System.out.println("\n****USER INPUTS****");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: "); //ask the user for input
        String name = input.nextLine();  //read the user's input 
        System.out.println("Nice to meet you, " + name + "!"); //print their input

        /*ARRAYS*/
        System.out.println("\n****ARRAYS****");
        int[] arrayNumbers = {1, 2, 3, 4, 5};
        //FOR LOOP 
        System.out.println("Printing arrayNumbers array...");
        for (int i = 0; i < arrayNumbers.length; i++) {
            System.out.println("For length of arrayNumbers array, print each item in array.");
            System.out.println("Index " + i + ": " + arrayNumbers[i]); //print each number in arrayNumbers array
        }

        /*ARRAYLIST (Dynamic List)*/
        System.out.println("\n****ARRAYLIST****");
        ArrayList<String> fruits = new ArrayList<>(); //create new arraylist

        //add to arraylist, one at a time 
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Printing fruits arraylist...");
        System.out.println("Fruits list: " + fruits); //print arraylist 

        /*LOOP*/
        System.out.println("\n****LOOP****");
        System.out.println("While i < 5, print i and add i by 1 each time go through loop...");
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        /*WHILE LOOP*/
        System.out.println("\n****WHILE LOOP****");
        int counter = 0;
        System.out.println("While couner is < 3, print counter. Where counter starts at 0...");
        while (counter < 3) {
            System.out.println("Counter = " + counter);
            counter++;
        }

        /*DO-WHILE LOOP*/
        System.out.println("\n****DO-WHILE LOOP****");
        int j = 0;
        System.out.println("Print j, while j < 2...");
        do {
            System.out.println("j = " + j); //print j
            j++;
        } while (j < 2); //while j is < 2 

        /*FOR EACH LOOP*/
        System.out.println("\n****FOR-EACH LOOP over fruits****");
        System.out.println("Print each element in list fruits...");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 8️⃣ Conditional statements
        System.out.println("\n****CONDITIONALS (IF/ELSE****");
        System.out.println("If age is >= 18, print you're an adult, else...");
        System.out.println("Where age is 20.");
        int age = 20;
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are not an adult yet.");
        }

        //CALLING METHODS
        System.out.println("\n****CALLING METHODS****");
        System.out.println("Call method addNumbers...");
        int sum = addNumbers(5, 7);
        System.out.println("\nSum of 5 and 7 is: " + sum);

        System.out.println("\nCalling method greetUser with variable name...");
        greetUser(name);

        //Closing the Scanner
        input.close();

        System.out.println("\n=== End of Demo ===");
    }

    // --- Methods ---
    // A method that adds two numbers and returns the result
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // A method that prints a greeting (void = returns nothing)
    public static void greetUser(String username) {
        System.out.println("Hello again, " + username + "! Welcome to methods!");
    }
}

/* OPERATORS
> Arithmetic: +, -, *, /, % (modulus)
> Assignment: =, +=, -=, *= etc.
> Comparison: ==, !=, <, >, <=, >=
> Logical: && (AND), || (OR), ! (NOT)
*/








// 5. Conditional Statements:
// Java

// if (condition) {
//     // Code if condition is true
// } else if (anotherCondition) {
//     // Code if anotherCondition is true
// } else {
//     // Code if no conditions are met
// }
// 6. Loops:
// For Loop.
// Java

//     for (int i = 0; i < 5; i++) {
//         System.out.println(i);
//     }
// While Loop.
// Java

//     int count = 0;
//     while (count < 5) {
//         System.out.println(count);
//         count++;
//     }
// Do-While Loop.
// Java

//     int num = 0;
//     do {
//         System.out.println(num);
//         num++;
//     } while (num < 5);
// 7. Arrays:
// Java

// int[] numbers = {1, 2, 3, 4, 5};
// System.out.println(numbers[0]); // Access element
// numbers[2] = 10; // Modify element
// 8. Methods (Functions):
// Java

// public static int add(int a, int b) {
//     return a + b;
// }

// // Calling the method
// int sum = add(5, 3); // sum will be 8
// 9. Input/Output:
// Java

// import java.util.Scanner;

// public class InputOutput {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter your name: ");
//         String name = scanner.nextLine();
//         System.out.println("Hello, " + name);
//         scanner.close();
//     }
// }
// 10. Comments:
// Java
