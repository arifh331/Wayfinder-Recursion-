# Wayfinder-Recursion-Program

This program solves a number puzzle established by the user him/herself. The program takes in commandline arguments as the numbers of 
this puzzle. These numbers of the has to be from 0 to 99 inclusive. And the final number of the puzzle(command line arguments) must be 
0.

The way this puzzle works is that all the numbers are placed in the order they were given in a horizontal line. The "objective" is to 
go to reach the end or the zero, starting from the first number. Each number represents the amount of steps that can be taken and these
"walks" can go any direction(left or right). 

What the program does determines if the puzzle given by the user(through command-line arguements) can actually be solved and if it can 
solved, the program will also print out the exact solutions on the console. The format of the solutions will simply show the puzzle but 
with directions on the specific numbers that were walked from. The program will list all the solutions of the puzzle and also tell the user
exactly how many solutions there in total.

Here are some examples:
If the user inputs  3 6 0 1 3 4 2 5 3 0, the program will output there are simply no solutions(because there aren't!)
  
On the other hand if the input is: 
3 6 4 1 3 4 2 5 3 0
The program will print:
[ 3R, 6 , 4R, 1L, 3 , 4R, 2R, 5 , 3L, 0 ]
[ 3R, 6R, 4R, 1R, 3L, 4R, 2R, 5L, 3L, 0 ]
[ 3R, 6 , 4R, 1R, 3R, 4R, 2R, 5L, 3L, 0 ]
There are 3 ways through the puzzle.

As you can see the specific directions are written on the numbers that were walked from and the program lists all the solutions!

The purpose of this solution is simply to work with the use of recursive algorithms in solving puzzles that may have multiple 
ways of solving the puzzle. It is also an exercise in showing how good recursive can explicitly list all the different solutions! 

The only rules in establishing the puzzle is making sure the numbers are passed as command line arguments, the numbers are between
0 and 99 inclusive and that the last number is a 0.

Try it!

