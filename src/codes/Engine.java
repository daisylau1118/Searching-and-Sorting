package codes;

import java.util.Scanner;

public class Engine {

	final static int SIZE = 100;
	static int [] numbers = new int [SIZE];
	
	public static int[] sequence (int SIZE)		//generates sequentially
	{
		for (int x = 0; x < SIZE; x++)
			numbers[x] = x + 1;		//adds 1 to the array every time
		
		return numbers;
	}
	
	public static int[] random (int SIZE)		//randomly generates
	{
		for (int x = 0; x < SIZE; x++)
			numbers[x] = (int)(Math.random()*SIZE+1);	//generates a random number and puts it into the array every time
		
		return numbers;
	}
	
	public static boolean ascending ()		//checks to see if the array is in ascending order
	{
		int count = 0;
		for (int x = 0; x < SIZE-1; x++)
		{
			if (numbers[x+1] >= numbers[x])		//checks if the next number in the array is greater than the current number
				count++;						//if it is, then add 1 to the count
		}
		
		if(count == (SIZE-1))		//if the count equals to 99, the array is in ascending order
			return true;
		else						//otherwise, the array is not in ascending order
			return false;
	}
	
	public static void shuffle () //shuffles the array 100 times until it is in a random order
	{
		for (int z = 0; z < SIZE; z++)
		{
			int y = (int)(Math.random()*SIZE);		//randomly generates a number to shuffle with
			int x = (int)(Math.random()*SIZE);		//randomly generates another number to shuffle with
			
			if (y == x)		//if the two random numbers happen to be the same number, x will change into another randomly generated number
				x = (int)(Math.random()*SIZE);
				
			int holder = numbers[y]; //loops 100 times and replaces the number and shuffles
			numbers[y] = numbers[x];
			numbers[x] = holder;
		}
	}
	
	public static int find (int need) //finds the inputed number
	{
		for (int x = 0; x < SIZE; x++)
		{			
			if (need == numbers[x])		//if the number is found in the array, it will return the place in the array
				return x+1;
		}
		
		return -1;				//if the number is not in the array, it will return -1
	}
	
 	public static void bubbleSort ()
	{
		for (int x = 0; x < SIZE-1; x++)
			for (int y = x + 1; y < SIZE; y++)
			{
				if (numbers[y] < numbers[x])		//if a number is less than the first number, swap
				{									//continues until all numbers are sorted
					int holder = numbers[y];
					numbers[y] = numbers[x];
					numbers[x] = holder;
				}
			}
	}
	
	public static int binarySearch (int need)
	{
		int min = numbers[0];
		int max = numbers[SIZE-1];
		
		for (int x = 0; x < SIZE; x++)
		{
			if (ascending() == true)			//if the numbers are sorted
			{
				int average = (max + min)/2;	//calculates the average
				
				if (average <= need)				//if the average is less than the number needed, the min will turn into the new average
					min = average;
				else if (average >= need)		//if the average is greater then the number needed, the max will turn into the new average
					max = average;
				else if (average == need)		//if the average is equal to the number you want to find, return the average
					return average;
			}
			else		//if the number is not found, say the search cannot be done
			{
				System.out.println("The search cannot be done because the array is not sorted or the number does not exist.");
				break;
			}
		}
		return -1;		//return -1 if the number is not found
	}
	
	public static void selectionSort ()
	{
		for (int x = 0; x < SIZE; x++)
		{
			int lowLocation = x;
			
			for (int y = x + 1; y < SIZE; y++)
				if (numbers[x] > numbers[y])		//if a number is less than the first number
				{
					lowLocation = y;				//stores the location of the lowest number
			
					int holder = numbers[x];		//after the lowest number is found, swap
					numbers[x] = numbers[lowLocation];
					numbers[lowLocation] = holder;
				}
		}
	}
	
	public static void insertionSort ()
	{
		for (int x = 1; x < SIZE; x++)
		{
			int temp = numbers[x-1];
			int counter = x - 1;
		
			while (counter >= 0 && numbers[x] > temp)
			{
				System.out.println(numbers[counter+1]);
				numbers[counter + 1] = numbers[counter];
				counter--;
			}
			
			numbers[counter + 1] = temp;
		}
	}
	
	public static void quickSort (int begin, int end)
	{
		int pivot = begin;
		int sliderLeft = begin;
		int sliderRight = end;
		
		while (sliderLeft != sliderRight)		//while the two sliders do not meet
		{
				while (numbers[sliderLeft] <= numbers[pivot] && sliderLeft < pivot)		//finds the first number that is greater than pivot on the left
					sliderLeft++;
				
				while (numbers[sliderRight] >= numbers[pivot] && sliderRight > pivot)	//finds the first number that is less than pivot on the left
					sliderRight--;
				
				if(sliderRight != sliderLeft)		//if the two sliders do not meet, swap
				{
					int holder = numbers[sliderRight];
					numbers[sliderRight] = numbers[sliderLeft];
					numbers[sliderLeft] = holder;
				}
				
				if (sliderLeft == pivot)	//if the left slider is equal to pivot and they swap, the pivot will become the place of the right slider
					pivot = sliderRight;
				else if (sliderRight == pivot)	//if the right slider is equal to pivot and they swap, the pivot will become the place of the left slider
					pivot = sliderLeft;
		}
		
		if ((sliderLeft-1) - begin > 1)			//if there are more than one card on the left, restart the quick sort for the left side
			quickSort(begin, sliderLeft - 1);
	
		if (end - (sliderRight+1) > 1)
			quickSort (sliderRight + 1, end);	//if there are more than one card on the right, restart the quick sort for the right side
		
	}
	
	public static void radixSort ()
	{
		int [] copy = new int[SIZE];
		int counter = 0;
		
		while (counter != 10)
		{
			for (int x = 0; x < SIZE; x++)
				for (int z = 0; z < SIZE; z++)
				{
					if (numbers[x] % 10 == counter)
						copy[z] = numbers[x];

				}
			counter++;
		}
		
		for (int x = 0; x < SIZE; x++)
			System.out.print(copy[x] + " ");
		
	}
	
	public static void numberFinder ()
	{
		/*int  
		for (int x = 0; x < SIZE; x++)
			if (numbers[x] % (10*counter) == )*/
		
	}
	
	public static void main(String[] args)
	{
		int instruction = 0;
		int value = 0;
		Scanner input = new Scanner(System.in);
		
		do
		{
			System.out.println();
			System.out.println("0. Exit the program.");
			System.out.println("1. Populate the array sequentially from 1 to 100.");
			System.out.println("2. Populate the array randomly.");
			System.out.println("3. Check if the list is in ascending order.");
			System.out.println("4. Display the array.");
			System.out.println("5. Shuffle the array.");
			System.out.println("6. Linear Search.");
			System.out.println("7. Bubble Sort");
			System.out.println("8. Binary Search");
			System.out.println("9. Selection Sort");
			System.out.println("10. Insertion Sort"); //make a method for shifting
			System.out.println("11. Quick Sort");
			System.out.println("12. Radix Sort"); //make a method for digit finding
			
			instruction = input.nextInt();
			
			if (instruction == 1)		//sequentially generates the array
			{
				sequence(SIZE);
				System.out.println("Populated!");
			}
			
			if (instruction == 2)		//randomly generates the array
			{
				random(SIZE);
				System.out.println("Populated!");
			}
	
			if (instruction == 3)		//checks if the array is in ascending order
			{
				if (ascending() == true)
					System.out.println("The list is in ascending order.");
				else
					System.out.println("The list is not in ascending order.");
			}
			
			
			if (instruction == 4)		//displays the populated array
			{
				for (int x = 0; x < SIZE; x++)
					System.out.print(numbers[x] + " ");
			}
			
			if (instruction == 5)		//shuffles he array 100 times until it is in a random order
				shuffle();
			
			if (instruction == 6)
			{
				System.out.println();
				System.out.println("Input the number you want to find:"); //asks for the number that wants to be found
				value = input.nextInt();		//stores into a variable and placed into the method to find the number
				
				System.out.println("The number you are looking for is in the " + find(value) + "th spot."); //prints out where the number is
			}
			
			if (instruction == 7)
				bubbleSort();			//launches the bubble sort
			
			if (instruction == 8)		
			{
				System.out.println();
				System.out.println("Input the number you want to find:");	//asks which number wants to be found
				value = input.nextInt();		//stores the number into a variable
				
				System.out.println("The number you are looking for is in the " + binarySearch(value) + "th spot.");
				//prints out the spot in the array the number is in
			}
			
			if (instruction == 9)
				selectionSort();		//launches the selection sort
			
			if (instruction == 10)
				insertionSort();		//launches the insertion sort
			
			if (instruction == 11)
				quickSort(0,SIZE-1);	//launches the quick sort
			
			if (instruction == 12)
				radixSort();			//launches the radix sort
				
			
		}while (instruction != 0);		//program runs infinitely until the person wants the program to end
		
		input.close();
	}
}