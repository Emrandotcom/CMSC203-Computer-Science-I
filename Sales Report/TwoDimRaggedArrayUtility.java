/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek 
 * Description: Create a utility class that manipulates a two-dimensional ragged array of doubles. 
 * 				This utility class will be used to create a Sales Report for Retail District #5. 
 * 				Create a utility class that will calculate holiday bonuses given a ragged array of doubles which represent the sales for each store in each category.  
 * Due: 08/03/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emran Abbamacha
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {
	}

	public static double[][] readFile(File file) throws FileNotFoundException {

		int rowNumber = 0;
		int columnNumber = 0;

		Scanner fileReader = new Scanner(file);

		String[][] firstArray = new String[10][];
		while (fileReader.hasNext()) {

			String[] list = fileReader.nextLine().split(" ");

			firstArray[rowNumber] = new String[list.length];

			columnNumber = list.length;

			for (int i = 0; i < list.length; i++)
				firstArray[rowNumber][i] = list[i];
			rowNumber++;
		}

		fileReader.close();

		double[][] doubleArray = new double[rowNumber][];

		for (int row = 0; row < doubleArray.length; row++) {
			if (firstArray[row] != null) {
				int size = firstArray[row].length;
				doubleArray[row] = new double[size];
				for (int col = 0; col < firstArray[row].length; col++) {
					doubleArray[row][col] = Double.parseDouble(firstArray[row][col]);
				}
			}
		}

		return doubleArray;
	}

	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {

		PrintWriter writeToFile = new PrintWriter(outputFile);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				writeToFile.print(data[i][j] + " ");
			}
			writeToFile.println();
		}

		writeToFile.close();

	}

	public static double getTotal(double[][] data) {

		double total = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++)
				total += data[row][col];
		}

		return total;
	}

	public static double getAverage(double[][] data) {
		double total = 0;
		int elements = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				elements++;
			}
		}

		return total / elements;
	}

	public static double getRowTotal(double[][] data, int row) {

		double totalRow = 0;

		for (int i = 0; i < data[row].length; i++) {
			totalRow += data[row][i];
		}

		return totalRow;
	}

	public static double getColumnTotal(double[][] data, int col) {

		double totalColumn = 0;

		for (int j = 0; j < data.length; j++) {
			if (col < data[j].length)
				totalColumn += data[j][col];
		}

		return totalColumn;
	}

	public static double getHighestInRow(double[][] data, int row) {

		double highestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (row < data[i].length) {
				if (highestRow < data[row][i]) {
					highestRow = data[row][i];
				}
			}
		}

		return highestRow;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {

		int highestRowIndex = 0;

		double highestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] > highestRow) {
				highestRow = data[row][i];
				highestRowIndex = i;
			}
		}

		return highestRowIndex;
	}

	public static double getLowestInRow(double[][] data, int row) {

		double lowestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (lowestRow > data[row][i]) {
				lowestRow = data[row][i];
			}
		}

		return lowestRow;
	}

	public static int getLowestInRowIndex(double[][] data, int row) {

		int lowestRowIndex = 0;

		double lowestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {

			if (lowestRow > data[row][i]) {
				lowestRow = data[row][i];
				lowestRowIndex = i;
			}

		}

		return lowestRowIndex;
	}

	public static double getHighestInColumn(double[][] data, int col) {

		double highestColumn = Double.MIN_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (highestColumn < data[i][col]) {
					highestColumn = data[i][col];
				}
			}
		}

		return highestColumn;

	}

	public static int getHighestInColumnIndex(double[][] data, int col) {

		int highestColumnIndex = 0;

		double highestRow = Double.MIN_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[highestColumnIndex][col] < data[i][col]) {
					highestRow = data[i][col];
					highestColumnIndex = i;
				}
			}
		}

		return highestColumnIndex;

	}

	public static double getLowestInColumn(double[][] data, int col) {

		double lowestColumn = Double.MAX_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (lowestColumn > data[i][col]) {
					lowestColumn = data[i][col];
				}
			}
		}

		return lowestColumn;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {

		int lowestColumnIndex = 0;

		double lowestColumn = Double.MAX_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (lowestColumn > data[i][col]) {
					lowestColumn = data[i][col];
					lowestColumnIndex = i;
				}
			}
		}

		return lowestColumnIndex;

	}

	public static double getHighestInArray(double[][] data) {

		double highestElement = data[0][0];

		for (int row = 1; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (highestElement < data[row][col]) {
					highestElement = data[row][col];
				}
			}
		}

		return highestElement;
	}

	public static double getLowestInArray(double[][] data) {

		double lowestElement = data[0][0];

		for (int row = 1; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (lowestElement > data[row][col]) {
					lowestElement = data[row][col];
				}
			}
		}

		return lowestElement;
	}

}
