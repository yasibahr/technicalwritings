using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        Console.WriteLine("=== C# Basics Demo ===");

        // Variables
        int number = 10;
        double price = 19.99;
        bool isCSFun = true;
        string message = "Hello, C#!";

        Console.WriteLine(number + " " + price + " " + isCSFun);
        Console.WriteLine(message);

        // Input
        Console.Write("\nEnter your name: ");
        string name = Console.ReadLine();
        Console.WriteLine("Nice to meet you, " + name + "!");

        // List
        List<string> fruits = new List<string>{"Apple", "Banana", "Cherry"};
        Console.WriteLine("\nFruits list:");
        foreach(var fruit in fruits) Console.WriteLine(fruit);

        // Loops
        Console.WriteLine("\nFor loop:");
        for(int i=0;i<5;i++) Console.WriteLine(i);

        Console.WriteLine("\nWhile loop:");
        int counter=0;
        while(counter<3){ Console.WriteLine(counter); counter++; }

        Console.WriteLine("\nDo-while loop:");
        int j=0;
        do{ Console.WriteLine(j); j++; } while(j<2);

        // Conditional
        int age = 20;
        if(age>=18) Console.WriteLine("You are an adult.");
        else Console.WriteLine("You are not an adult yet.");

        // Functions
        int sum = AddNumbers(5,7);
        Console.WriteLine("\nSum of 5 and 7: " + sum);
        GreetUser(name);
    }

    static int AddNumbers(int a,int b){ return a+b; }
    static void GreetUser(string username){ Console.WriteLine("Hello again, "+username+"!"); }
}
