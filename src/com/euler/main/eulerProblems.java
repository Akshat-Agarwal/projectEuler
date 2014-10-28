package com.euler.main;
import java.io.IOException;
import com.euler.problems.Problem1;
import com.euler.problems.Problem11;
import com.euler.problems.Problem13;
import com.euler.problems.Problem25;
import com.euler.problems.Problem43;

public class eulerProblems {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Problem1 problem1 = new Problem1();
		Problem11 problem11 = new Problem11();
		Problem13 problem13 = new Problem13();
		Problem25 problem25 = new Problem25();
		Problem43 problem43 = new Problem43();
		
		System.out.println(problem25.solve());
		
	}
}
