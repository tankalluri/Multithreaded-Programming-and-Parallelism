package multithreading.assignment.ass1.q5;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileReaderTask {
	
	public static void contentsOfFile(String[] splitString, List<String> letterToList){
		System.out.println("Contents of the file:");
		for (int i = 0; i < splitString.length; i++) {
			System.out.println(splitString[i]);
			letterToList.add(splitString[i]);
		}
	}
	
	public static void upperCaseList(Map<String, Integer> countMap, List<String> letterToList){
		System.out.println("Contents of the list after changing to uppercase:");
		for (int j = 0; j < letterToList.size(); j++) {
			System.out.println(letterToList.get(j).toUpperCase());
		}
	}
	
	public static void listLength(List<String> letterToList){
		System.out.println("The length of the list is " + letterToList.size());
	}
	
	public static void elementOccurrence(List<String> letterToList){
		Map<String, Integer> hm = new HashMap<String, Integer>(); 
        for (String i : letterToList) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1); 
        }
        System.out.println("Occurrences of elements in list:");
        for (Map.Entry<String, Integer> val : hm.entrySet()) { 
            System.out.println(val.getKey() + " "+ "occurs" + ": " + val.getValue() + " times"); 
        }
        sortbykey(hm);
	}
	
	public static void sortbykey(Map<String, Integer> hm)
	{ 
        TreeMap<String, Integer> sorted = new TreeMap<>(); 
        sorted.putAll(hm); 
        System.out.println("Sort by key");
        for (Map.Entry<String, Integer> entry : sorted.entrySet())  
            System.out.println("Key = " + entry.getKey() +  
                         ", Value = " + entry.getValue());         
    } 


	public static void main(String[] args) {
		List<String> letterToList = new ArrayList<String>();
		Map<String, Integer> countMap = new HashMap<>();
		BufferedReader br=null;
		try {
			 br = new BufferedReader(new FileReader("C:\\\\Users\\\\tankalluri\\\\eclipse-workspace\\\\Multithreading\\\\src\\\\multithreading\\\\assignment\\\\ass1\\\\q5\\\\data.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			String line;
			while ( (line = br.readLine()) != null) {
				System.out.println(line);
				String[] splitString = line.split(",");
				contentsOfFile(splitString,letterToList);
				upperCaseList(countMap,letterToList);
				listLength(letterToList);
				elementOccurrence(letterToList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
