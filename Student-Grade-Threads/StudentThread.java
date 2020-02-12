package multithreading.assignment.ass2.q2;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class StudentThread extends Thread {

	StudentThread(int id) throws IOException{
		Thread.currentThread().setName("name-Thread-"+id);
		System.out.println("Thread "+Thread.currentThread().getName()+" is running");
		
		Student s = new Student();
		Random rand = new Random();
		
		try {
			generateFinalMarks(rand,s);
			Thread.sleep(1000);
			generateMidMarks(rand,s);
			Thread.sleep(1000);
			generateProject(rand,s);
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		writeDataToGraderFile(id, Thread.currentThread().getName(), s);
	}
	
	static int generateFinalMarks(Random rand, Student s) {
		int val = rand.nextInt(50+1)+50;
		s.setFinalMarks(val);
		return val;
	}
	
	static int generateProject(Random rand, Student s) {
		int val = rand.nextInt(50+1)+50;
		s.setProject(val);
		return val;
	}
	
	static int generateMidMarks(Random rand, Student s) {
		int val = rand.nextInt(50+1)+50;
		s.setMidMarks(val);
		return val;
	}
	
	public void writeDataToGraderFile(int ids, String threadId, Student s) throws IOException {
		 File file = new File("C:\\Users\\tankalluri\\eclipse-workspace\\Multithreading\\src\\multithreading\\assignment\\ass2\\q2\\output.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		 s.setId(ids);
		 s.setName("Student"+ids);
	     BufferedWriter bw = new BufferedWriter(fw);
	     System.out.println("Student"+ids+","+ids+","+threadId+","+s.getMidMarks()+","+s.getProject()+","+s.getFinalMarks());
	     System.out.println("___________________________________________________");
	     synchronized (this) {
	    	 if (!file.exists()) 
		        {
		             file.createNewFile();
		        }
		        bw.write("Student"+ids+","+ids+","+threadId+","+s.getMidMarks()+","+s.getProject()+","+s.getFinalMarks());
		        bw.newLine();
		        bw.close();
		}
	}
}
