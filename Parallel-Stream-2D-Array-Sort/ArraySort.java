package multithreading.assignment.ass6.q3;

import java.util.ArrayList;
import java.util.List;

public class ArraySort {

	public static void main(String args[]) {
		int[][] arr = { { 9, 12, 6, 14, 10, 21, 13}, { 3, 5, 41, 16, 14, 10, 21}, 
				   { 3, 15, 41, 17, 11, 10, 51}, { 3, 15, 41, 17, 11, 10, 51},
				   { 4, 15, 35, 17, 11, 12, 55}, { 2, 16, 31, 18, 12, 11, 42} }; 
		List<List<Integer>> l = convertToList(arr);
		System.out.println("Before sort");
		System.out.println(l);
		l.parallelStream().forEach((list) ->{
            Thread t = new Thread(new Process(list));
            t.start();
        });
		System.out.println("After sort");
        l.forEach((list) -> System.out.println(list));

	}
	
	public static List<List<Integer>> convertToList(int[][] twoDArray) {
		List<List<Integer>> list = new ArrayList<>();
        for (int[] array : twoDArray) {
            List<Integer> list2 = new ArrayList<Integer>();
            for (int arr : array) {
                Integer arrInt = new Integer(arr);
                list2.add(arrInt);
            }
            list.add(list2);
        }
        return list;
	}
}
