// Variables
let message = "Hello, JavaScript!";
let counter = 0;

// Event Listener for button
document.getElementById("btn").onclick = () => {
    counter++;
    document.getElementById("greeting").innerText = `${message} Clicked ${counter} times`;
    document.getElementById("greeting").classList.toggle("highlight");
    console.log(`Button clicked ${counter} times`);
};

// Loop example
console.log("Numbers 0 to 4:");
for (let i = 0; i < 5; i++) console.log(i);
