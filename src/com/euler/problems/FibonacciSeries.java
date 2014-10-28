package com.euler.problems;

//This class' solve method solve will return the fibonacci number at the term provided as a parameter
public class FibonacciSeries {

	private static int solve(int fibTerm){
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
}
