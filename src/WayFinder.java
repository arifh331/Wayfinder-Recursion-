import java.util.Arrays;


/**
 * The purpose of this class is to recursively solve a puzzle. 
 * The puzzle is a list of numbers and solving the puzzle is trying 
 * to reach the end of the list if one(cursor) can only move left or 
 * right at a distance determined by the number the cursor is on.
 * The out-put in the console are all the possible solutions for that particular puzzle.
 * The console also displays exactly how many total solutions there are for this 
 * particular puzzle or arrangement of numbers. 
 * This is not a interactive class and works through command line arguments. 
 * 
 * @author Arif Howlader
 *
 */

public class WayFinder {

	/**
	 * The main method of this program. This is what drives the program. 
	 * @param args array of Strings provided on the command line when the program is started
	 * The array of strings is going to be all numbers and will form the puzzle
	 */
	public static void main(String[] args) {


		//This is checking if command line arguments are passed. If they are not passed, then the program terminates. 
		if (args.length == 0) {
			System.err.println("Error: incorrect usage. At least one arguement is required");
			System.exit(1);
		}
		

		//This is an integer array that will store all the numbers in the array of strings
		int [] aiaray = new int [args.length];

		//This for loop is first converting each slot of the array of strings into integers
		//and then storing these integers in the recently created array of integers 
		//This loop also checks if arguments are actually numerical Digits 
		for(int i= 0; i<= aiaray.length-1; i++) {
			
			
			//The try block is actually checking if only have Numerical Digits
			//If I don't the exception will be catched and the program will terminate 
			try {
			int icheck = Integer.parseInt(args[i]);
			aiaray[i]= icheck;
			}
			
			catch(NumberFormatException ex) {
				System.err.println("Error: Incorrect Usage. Only numerical digits are accepted");
				System.exit(1);
			}
			
			//There seemed to have been some error if I didn't declare this variable again 
			int icheck = Integer.parseInt(args[i]);
			aiaray[i]= icheck;
			
			//This if statement is just checking if the argument passed is actually within the specified range
			// of 0 to 99
			if (icheck<0 || icheck>99) {
				System.err.println("Error: the puzzle values have to be positive integers in range [0, 99].");
				System.exit(1);
			}
			
			
		}

		//This if statement is making sure the last number of the puzzle is 0. 
		if (aiaray[aiaray.length-1] != 0) {
			System.err.println("Error: the last number of the puzzle must be 0");
			System.exit(1);
		}

		// The puzzles recursive function is being called here.
		//The first variable passed is the integer array, second is the starting index(0), 
		//third is the array of strings command line argument, and fourth is the value of the 
		//counter variable which all count how many solutions are present for a puzzle
		puzzles(aiaray, 0, args, 0);


	}


	/**
	 * This is a four - parameter wrapper method. This is not the actual method where the recursion occurs.
	 * Rather this method is used to determine which statement should be printed in the console for the user 
	 * This is determined by the amount of solutions returned by the actual recursion(non- wrapper)
	 * method. The value of which is recorded onto a counter variable  
	 * @param wbob This is the integer array that has all the numbers of the puzzles 
	 * @param windex THis is the index value where the cursor is cursor is currently at.
	 * There is the "decision" for the function to take a direction(left or right) depending what 
	 * is necessary to reach the end. 
	 * @param wwords This is the string array where the numbers are contained and which will be altered with 
	 * the "R" or "L" depending on which is needed for the solution. This is the array that will be printed in the 
	 * end.
	 * @param wcounter This is the counter variable which gets the value of the amount of solutions from the actual 
	 * recursion method. That value helps decide what will be printed. 
	 */
	static void puzzles(int[] wiarray, int windex, String[] wwords, int wcounter) {
		wcounter= puzzles(wiarray, windex, wwords);

		//This is the instance there is no solution or ways to solve this puzzle.
		if (wcounter== 0) {
			System.out.println("No way through this puzzle.");
		}

		//This is to print the message given only 1 solution to the puzzle.
		if (wcounter== 1) {
			System.out.println("There is "+wcounter+" way through the puzzle.");
		}

		//This is what is to be printed if there is more than 1 solution to the puzzle. 
		if (wcounter >1) {
			System.out.println("There are "+wcounter+" ways through the puzzle.");
		}
	}


	/**
	 * This is the actual 3- parameter recursion function where the recursion occurs. 
	 * This goes through the puzzle and finds exactly how many different solutions can be found 
	 * and out-puts that value. 
	 * @param wbob This is the integer array that has all the numbers of the puzzles 
	 * @param windex THis is the index value where the cursor is cursor is currently at.
	 * There is the "decision" for the function to take a direction(left or right) depending what 
	 * is necessary to reach the end. 
	 * @param wwords This is the string array where the numbers are contained and which will be altered with 
	 * the "R" or "L" depending on which is needed for the solution. This is the array that will be printed in the 
	 * end.
	 * @return What's returned is an integer value of the amount of possible solutions for the puzzle
	 */
	static int puzzles(int[] iarray, int index, String[] sarray) {

		//The counter restarts at zero for ever recursion 
		 int counter= 0; 

		// This is the base case which is when the index reaches the last spot/ index
		// This is where the toString method is called which prints out the solutions and specific orders are 
		// printed. 
		if (index== iarray.length-1) {
			//This is formatting the first index of the string
			

			//This is the for-loop where strings are formatted one by one
			for (int i=0; i<=sarray.length-1; i++) {
				//This is making sure to print out the proper output is printed for the first index
				if (i==0) {
					if (sarray.length>1) {
					System.out.printf("%s%s%2s%s","["," ",sarray[0],",");
					}
					//This is making sure the output at the zeroth index when its the only output, is correct
					else {
						System.out.printf("%s%2s%s%s\n","[",sarray[0]," ","]");
						
					}
				}
				
				//These are if statements that prints the appropriate number/letter outputs
				//depending on if they have the contains R and L 
				//These outputs are printed in formatted manner appropriate to the project descriptions 
				if ((i!=0)&&(i!=sarray.length-1)&& ((sarray[i].contains("R")) || (sarray[i].contains("L")))) {
					System.out.printf("%s%3s%s"," ",sarray[i],",");
				}
				if ((i!=0)&&(i!=sarray.length-1)&& !(sarray[i].contains("R")) && !(sarray[i].contains("L"))) {
					System.out.printf("%s%2s%s%s"," ",sarray[i]," ",",");
				}
				if ((i==sarray.length-1)&&(sarray.length!=1)) {
					System.out.printf("%s%2s%s%s\n"," ",sarray[i]," ","]");
				}
			}
			


			//1 is returned, symbolizing that a solution has been found. These 1s are added up. 
			return 1;

		}




		//If statement checking if the cursor can go Right, making sure that it doesn't go out of bounds or also  
		// checks if there is already present R or L on it. If there is, then the cursor can't reach here
		if (((index + iarray[index]) <= iarray.length-1) && !(sarray[index].contains("R")|| (sarray[index].contains("L"))   ) ) { 

			//If the cursor successfully reached here then, you can add add a R next to the number on the array 
			sarray[index] += "R";

			//The current counter value (0) is added to another recursive call with the index now being at the  
			//place where we leapt to which depends on the number of the previous index. This is going right
			counter += puzzles(iarray, index + iarray[index], sarray);

			//The R is now taken out of the array of strings so other recursions can be done dissociated with this 
			// Specific function call
			sarray[index]= sarray[index].substring(0, sarray[index].length()-1);

		}




		//If statement checking if the cursor can go Left, making sure that it doesn't go out of bounds(behind the zero index) or also  
		// checks if there is already present R or L on it. If there is, then the cursor can't reach here
		if (((index - iarray[index]) >0) && !(sarray[index].contains("R")|| (sarray[index].contains("L"))   ) ) { 

			//If the cursor successfully reached here then, you can add add a L next to the number on the array 
			sarray[index] += "L";


			//The current counter value (0) is added to another recursive call with the index now being at the  
			//place where we leapt to which depends on the number of the previous index. This is going left
			counter+= puzzles(iarray, index - iarray[index], sarray);

			//The L is now taken out of the array of strings so other recursions can be done dissociated with this 
			//Specific function call
			sarray[index]= sarray[index].substring(0, sarray[index].length()-1);

		}


		//The counter value should be returned
		//If a solution was found then, 1 would be returned 
		//If no solution was found then, 0 would be returned
		return counter;
	}
}



