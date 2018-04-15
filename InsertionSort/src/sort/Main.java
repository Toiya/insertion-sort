package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Integer> sort(ArrayList<Integer> input) {

		for (int i = 1; i < input.size(); i++){

			int index = input.get(i);

			for (int j = i-1; j >= 0; j--){
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
	
	public static void print(ArrayList<Integer> list) {
		for (int i: list) {
			System.out.print(i + "\n");
		}
	}
	
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Integer> list = listFromFile("C:\\Users\\Elvira\\Downloads\\slumpad.txt");
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
		
		
//		print(list1);
//		System.out.println("\n");
		sort(list);
//		print(list1);
		
		for (int i = 1; i < list.size() - 1; i++) {
    		System.out.println(list.get(i - 1) < list.get(i));
    	}
	}

}
