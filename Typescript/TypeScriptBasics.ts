// Variables
let number: number = 10;
let price: number = 19.99;
let isFun: boolean = true;
let message: string = "Hello, TypeScript!";

console.log(number, price, isFun);
console.log(message);

// Functions
function addNumbers(a: number, b: number): number {
    return a + b;
}

function greetUser(name: string): void {
    console.log(`Hello again, ${name}!`);
}

let sum = addNumbers(5, 7);
console.log("Sum of 5 + 7:", sum);
greetUser("Alice");

// Loops
console.log("\nFor loop:");
for (let i = 0; i < 5; i++) console.log(i);

console.log("\nWhile loop:");
let counter = 0;
while (counter < 3) { console.log(counter); counter++; }
