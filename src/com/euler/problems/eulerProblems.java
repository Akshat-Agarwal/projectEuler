package com.euler.problems;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class eulerProblems {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println(problem43());
		
	}
	
	public static long problem43(){
		//Creating an int array to store our pandigital number
		int[] pandigitalNum = new int[10];

		return -1;
	}
	
	//Current method, instead of looking into 8 directions, look into 4 different directions. Horizontal-right. Vertical-down.
	//Diagonal-right. Diagonal-left. Since every other direction will be covered by these 4.
	@SuppressWarnings("resource")
	private static int problem11() throws IOException{
		
		int maxProduct = 0;
		String[][] stringArray = new String[20][];
		int[][] intArray = new int[20][];
		
		//Reading 20x20 elements of the grid from a file and storing into stringArray
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:/Users/Akshat Agarwal/Desktop/2B/ProjectEuler/problem11.txt"));
			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				//Once 20 lines have been read, end of file
				if(i == 20){
					break;
				}
				String[] innerArray = new String[]{line};
				//Using space as delimiter for 'line' putting the correct value in arrays
				stringArray[i] = line.split("\\s", 20);
				//initializing intArray as well
				intArray[i] = new int[20];
			    i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//converting string to int
		for(int i=0; i<19; i++){
			for(int j=0; j<19; j++){
				intArray[i][j] = Integer.parseInt(stringArray[i][j]);
			}
		}

		//for local product
		int product = 0;
		for(int i=0; i<=19; i++){
			for(int j=0; j<=19; j++){
				//Checking vertically down for the highest product
				if(i <=16){
					product = intArray[i][j] * intArray[i+1][j] *
								intArray[i+2][j] * intArray[i+3][j];
					maxProduct = (product > maxProduct) ? product : maxProduct;
				}
				//checking horizontally to the right for the highest product
				if(j <=16){
					product = intArray[i][j] * intArray[i][j+1] *
								intArray[i][j+2] * intArray[i][j+3];
					maxProduct = (product > maxProduct) ? product : maxProduct;
				}
				//Checking diagonally towards top left
				if(i >= 3 && j >= 3){
					product = intArray[i][j] * intArray[i-1][j-1] *
								intArray[i-2][j-2] * intArray[i-3][j-3];
					maxProduct = (product > maxProduct) ? product : maxProduct;
				}
				//checking diagonally towards top right
				if(i >= 3 && j <= 16){
					product = intArray[i][j] * intArray[i-1][j+1] *
								intArray[i-2][j+2] * intArray[i-3][j+3];
					maxProduct = (product > maxProduct) ? product : maxProduct;
				}
			}
		}
		
		return maxProduct;
	}
	
	private static int problem25(){
		final double g = (Math.sqrt(5) + 1) / 2;
		int i = 1;
		double temp = 1;
		while(temp < 999){
			i++;
			temp = i * Math.log10(g) + Math.log10(1/Math.sqrt(5));			
		}
		return i;
	}
	
	private static int fibonacci(int fibTerm){
		//For first 2 terms of fibonacci sequence
		if(fibTerm < 3){
			return 1;
		}
		//For terms less than 0, fib sequence doesnt exist
		if(fibTerm < 0){
			return -1;
		}
		int[] array = new int[fibTerm];
		array[0] = 1;
		array[1] = 1;
		
		for(int i=2; i<fibTerm; i++){
			array[i] = array[i-1]+array[i-2];
		}
		
		return array[fibTerm-1];
	}

	
	//Problems Based on C:\Users\Akshat Agarwal\Desktop\2B\Resume\Enflick Problems Codility\Enflick1.PNG
	private static int problemEnflick1(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		//Go through the array A
		for(int i=0; i<A.length; i++){
			//Storing current lowest number
			int lowNum = A[i];
			
			//Checking if lowNum is in B
			for(int j=0; j<B.length; j++){
				if(B[j] == lowNum){
					return lowNum;
				}
				//Value in second array is bigger than what we currently have in lowNum, thus break
				if(B[j] > lowNum){
					break;
				}
			}
		}
		//Couldnt find a common number in both arrays, return -1
		return -1;
	}
	
	//Problems Based on C:\Users\Akshat Agarwal\Desktop\2B\Resume\Enflick Problems Codility\Enflick2.PNG
	private static int problemEnflick2() {
		String a = "JANUARY";
		if(months.JANUARY == months.name(a)){
			System.out.println(a);
		}
		
		System.out.println(months.FEBRUARY.numDays);
		return 0;
		
//		//Changing the number of days in FEBRUARY in a leap year
//		months.changeNumDays(months.FEBRUARY, 29);
	}
	
	public enum days{
		MONDAY(1),
		TUESDAY(2),
		WEDNESDAY(3),
		THURSDAY(4),
		FRIDAY(5),
		SATURDAY(6),
		SUNDAY(7);
		
		private int value;
		
		private days(int v){
			value = v;
		}
	}
	
	public enum months{
		JANUARY(1,31),
		FEBRUARY(2,28),
		MARCH(3,31),
		APRIL(4,30),
		MAY(5,31),
		JUNE(6,30),
		JULY(7,31),
		AUGUST(8,31),
		SEPTEMBER(9,30),
		OCTOBER(10,31),
		NOVEMBER(11,30),
		DECEMBER(12,31);
		
		private int value;
		private int numDays;
		
		private months(int v, int numOfDays){
			value = v;
			numDays = numOfDays;
		}
		
		//To change the number of days in a particular month, ie. if its a leap year
		public static void changeNumDays(months month, int newNumDays){
			month.numDays = newNumDays;
		}
		
		public static months name(String monthName){
			switch(monthName){
			case "JANUARY" : 
				return JANUARY;
			
			case "FEBRUARY":
				return FEBRUARY;
			
			case "MARCH":
				return MARCH;
			
			case "APRIL":
				return APRIL;

			case "MAY":
				return MAY;
			
			case "JUNE":
				return JUNE;
			
			case "JULY":
				return JULY;
			
			case "AUGUST":
				return AUGUST;
			
			case "SEPTEMBER":
				return SEPTEMBER;
			
			case "OCTOBER":
				return OCTOBER;
			
			case "NOVEMBER":
				return NOVEMBER;
			
			case "DECEMBER":
				return DECEMBER;
			}			
			return null;
		}
	}

	private static void problem1(){
		int sum = 0;
		
		for(int i=1; i<1000 ; i++){
			if((i%3 == 0) || (i%5 == 0)){
				sum+=i;
			}
		}
		
		System.out.println(sum);
	}
	
	private static void problem13() throws FileNotFoundException{
		try {
			BigInteger bigNum;
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Akshat Agarwal/Desktop/champter 3.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				bigNum = new BigInteger(line);
			    System.out.println(bigNum);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
