<?php
// Variables
$number = 10;
$price = 19.99;
$isFun = true;
$message = "Hello, PHP!";

echo "$number, $price, $isFun\n";
echo "$message\n";

// Function
function addNumbers($a, $b) {
    return $a + $b;
}

function greetUser($name) {
    echo "Hello again, $name!\n";
}

$sum = addNumbers(5, 7);
echo "Sum of 5 + 7: $sum\n";
greetUser("Alice");

// Loops
echo "\nFor loop:\n";
for($i=0;$i<5;$i++) echo "$i\n";

echo "\nWhile loop:\n";
$counter = 0;
while($counter < 3){
    echo "$counter\n";
    $counter++;
}

// Conditional
$age = 20;
if($age >= 18){
    echo "You are an adult.\n";
}else{
    echo "You are not an adult yet.\n";
}
?>
