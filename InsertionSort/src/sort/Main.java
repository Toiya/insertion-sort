package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	/**
	 * Sorts the given ArrayList in ascending order
	 * @param ArrayList to be sorted
	 * **/
	public static ArrayList<Integer> sort(ArrayList<Integer> input) {

		for (int i = 1; i < input.size(); i++){

			int index = input.get(i);

			for (int j = i-1; j >= 0; j--){
				//OBS!! If you want to sort in descending order instead, this is the < you want to flip.
				if (index < input.get(j)) {
					// Shift each element to the right as index is less than the existing element at current index
					input.set(j + 1, input.get(j));

					// If all other elements are less than element at index, set first in list
					if (j == 0){
						input.set(0, index);
					}
				} else {
					// Putting index value after element at current index as index value is no more less than the existing element at current index
					input.set(j + 1, index);
					break;
				}
			}
		}   
		return input;
	}
	
	
	/**
	 * Prints the given ArrayList with a new line between each element
	 * @param ArrayList to be printed
	 * **/
	public static void print(ArrayList<Integer> list) {
		for (int i: list) {
			System.out.print(i + "\n");
		}
	}
	
	/**
	 * Makes an ArrayList from a file. The file has to have the numbers separated by spaces.
	 * @param A string filename
	 * @return An ArrayList with the numbers from file
	 * **/
	public static ArrayList<Integer> listFromFile(String filename) throws NumberFormatException, IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] strNumbers = line.split(" ");
			for (String strNumber: strNumbers) {
				list.add(Integer.parseInt(strNumber));
			}
		}
		br.close();
		return list;
	}
	
	//Just for testing
	public static void main(String[] args) throws NumberFormatException, IOException {
//		ArrayList<Integer> list = listFromFile("FILENAME");
		
		//Integer Arraylist
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(5);
		list1.add(11);
		list1.add(12);
		list1.add(1);
		list1.add(2);
		list1.add(6);
		list1.add(7);
		list1.add(8);
		list1.add(9);
		list1.add(3);
		list1.add(4);
		list1.add(10);
		
		sort(list1);
		print(list1);
	}

}
