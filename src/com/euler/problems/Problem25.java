package com.euler.problems;

public class Problem25 {
	
	public int solve(){
		final double g = (Math.sqrt(5) + 1) / 2;
		int i = 1;
		double temp = 1;
		while(temp < 999){
			i++;
			temp = i * Math.log10(g) + Math.log10(1/Math.sqrt(5));			
		}
		return i;
	}
}
