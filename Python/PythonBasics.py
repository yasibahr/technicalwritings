# Python Basics Demo

# 1. Variables
number = 10
price = 19.99
is_python_fun = True
message = "Hello, Python!"

print(number, price, is_python_fun)
print(message)

# 2. Input
name = input("\nEnter your name: ")
print(f"Nice to meet you, {name}!")

# 3. List (like ArrayList)
fruits = ["Apple", "Banana", "Cherry"]
print("\nFruits list:", fruits)

# 4. Loops
print("\nFor loop:")
for i in range(5):
    print(i)

print("\nWhile loop:")
counter = 0
while counter < 3:
    print(counter)
    counter += 1

# 5. Conditional
age = 20
if age >= 18:
    print("You are an adult.")
else:
    print("You are not an adult yet.")

# 6. Functions
def add_numbers(a, b):
    return a + b

def greet_user(username):
    print(f"Hello again, {username}!")

sum_result = add_numbers(5, 7)
print("\nSum of 5 and 7:", sum_result)
greet_user(name)
