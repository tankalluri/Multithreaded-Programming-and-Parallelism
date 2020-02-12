package multithreading.assignment.ass2.q2;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GraderThread extends Thread{

	GraderThread() throws IOException, InterruptedException{
		readFromFile();
	}
	
	public void readFromFile() throws IOException, InterruptedException {
		Student s = new Student();
		readDataFromFile(s);
	}
	
	public void readDataFromFile(Student s) throws IOException, InterruptedException {
		String l =  null;
		Map<String, Character> map = new HashMap<>();
		char c;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tankalluri\\eclipse-workspace\\Multithreading\\src\\multithreading\\assignment\\ass2\\q2\\output.txt"));
		while((l =br.readLine()) != null) {
			Thread.sleep(30000);//30s wait
			String sp [] = l.split(",");
			s.setName(sp[0]);
			s.setMidMarks(Integer.parseInt(sp[3]));
			s.setProject(Integer.parseInt(sp[4]));
			s.setFinalMarks(Integer.parseInt(sp[5]));
			c= calculateGrade(s);
			map.put(s.getName(), c);
		}
		displayFromMap(map);
		br.close();
	}
	
	public char calculateGrade(Student s) throws IOException {
		char grade;
		double total =  0.3*s.getMidMarks()+0.3*s.getProject()+0.4*s.getFinalMarks();
		if(total>=90)
			grade = 'A';
		else if(total>=80 && total<90)
			grade = 'B';
		else if(total>=70 && total<80)
			grade = 'C';
		else if(total>=60 && total<70)
			grade = 'D';
		else
			grade = 'F';
		writeGradeToFile(s.getName(),grade);
		return grade;
	}
	
	public void writeGradeToFile(String name, char grade) throws IOException {
		 File file = new File("C:\\Users\\tankalluri\\eclipse-workspace\\Multithreading\\src\\multithreading\\assignment\\ass2\\q2\\outputFinal.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
	     BufferedWriter bw = new BufferedWriter(fw);
	     synchronized (this) {
	    	 if (!file.exists()) 
		        {
		             file.createNewFile();
		        }
		        bw.write(name+" got grade "+grade);
		        bw.newLine();
		        bw.close();
		}
	}
	
	public void displayFromMap(Map<String, Character> map) {
		System.out.println("Printing  values from Hash Map....");
		map.forEach((key, val) ->
		System.out.println(key+" has grade "+val));
	}
}
