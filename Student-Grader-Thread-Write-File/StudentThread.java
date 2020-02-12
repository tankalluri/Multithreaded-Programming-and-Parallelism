package multithreading.assignment.ass3.q3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StudentThread extends Thread {

	StudentThread(int id, Map<String,List<Integer>> map) throws IOException{
		Thread.currentThread().setName("name-Thread-"+id);
		System.out.println("Thread "+Thread.currentThread().getName()+" is running");
		
		Student s = new Student();
		Random rand = new Random();
		List<Integer> marks = new ArrayList<>();
		
		try {
			s.setName("Student"+id);
			generateFinalMarks(rand,s);
			Thread.sleep(1000);
			addDataToList(s.getFinalMarks(), marks);
			generateMidMarks(rand,s);
			Thread.sleep(1000);
			addDataToList(s.getMidMarks(), marks);
			generateHomework(rand,s);
			Thread.sleep(1000);
			addDataToList(s.getHomework(), marks);
			generateQuizMarks(rand, s);
			Thread.sleep(1000);
			marks = addDataToList(s.getQuizMarks(), marks);
			map = writeToMap(map, marks, s.getName());
			System.out.println(map);
			//readFromFile();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public StudentThread() throws IOException {
		readFromFile();
	}

	static int generateFinalMarks(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setFinalMarks(val);
		return val;
	}
	
	static int generateHomework(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setHomework(val);
		return val;
	}
	
	static int generateMidMarks(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setMidMarks(val);
		return val;
	}
	
	static int generateQuizMarks(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setQuizMarks(val);
		return val;
	}
	
	static synchronized List<Integer> addDataToList(int points, List<Integer> marks) {
		 marks.add(points);
		 return marks;
	}
	
	static synchronized Map<String,List<Integer>> writeToMap(Map<String,List<Integer>>map, List<Integer> marks, String name){
		map.put(name, marks);
		return map;
	}
	
	static synchronized void readFromFile() throws IOException {
		String l;
		BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\tankalluri\\\\eclipse-workspace\\\\Multithreading\\\\src\\\\multithreading\\\\assignment\\\\ass3\\\\q3\\\\FinalGrades.txt"));
		while((l =br.readLine()) != null) {
			System.out.println(l);
		}
	}
}
