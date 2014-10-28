package com.euler.problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

//Incomplete solution
public class Problem13 {
	
	public void solve() throws FileNotFoundException{
		try {
			BigInteger bigNum;
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Akshat Agarwal/Desktop/numbers.txt"));
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
