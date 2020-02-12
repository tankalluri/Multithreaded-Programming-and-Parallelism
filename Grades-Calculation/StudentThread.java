package multithreading.assignment.ass4.q4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StudentThread extends Thread {
	
	ReadWriteLock lock=new ReentrantReadWriteLock();
    Lock read=lock.readLock();
    Lock write=lock.writeLock();

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

	public int generateFinalMarks(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setFinalMarks(val);
		return val;
	}
	
	public int generateHomework(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setHomework(val);
		return val;
	}
	
	public int generateMidMarks(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setMidMarks(val);
		return val;
	}
	
	public int generateQuizMarks(Random rand, Student s) {
		int val = rand.nextInt(70+1)+30;
		s.setQuizMarks(val);
		return val;
	}
	
	public List<Integer> addDataToList(int points, List<Integer> marks) {
		try {
		write.lock();
		 marks.add(points);
		 return marks;
		}
		finally {
			write.unlock();
		}
	}
	
	public Map<String,List<Integer>> writeToMap(Map<String,List<Integer>>map, List<Integer> marks, String name){
		try {
		write.lock();
		map.put(name, marks);
		return map;
		}
		finally {
			write.unlock();
		}
	}
	
	public void readFromFile() throws IOException {
		try {
		read.lock();
		String l;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tankalluri\\eclipse-workspace\\Multithreading\\src\\multithreading\\assignment\\ass4\\q4\\FinalGrades.txt"));
		while((l =br.readLine()) != null) {
			System.out.println(l);
		}
		}
		finally {
			read.unlock();
		}
	}
}
