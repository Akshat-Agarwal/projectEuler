package com.euler.problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem11 {

	//Current method, instead of looking into 8 directions, look into 4 different directions. Horizontal-right. Vertical-down.
		//Diagonal-right. Diagonal-left. Since every other direction will be covered by these 4.
		@SuppressWarnings("resource")
		public int solve() throws IOException{
			
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
}
