package multithreading.assignment.ass6.q5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GraderThread extends Thread {
	
	ReadWriteLock lock=new ReentrantReadWriteLock();
    Lock read=lock.readLock();
    Lock write=lock.writeLock();

	GraderThread(Map<String, List<Integer>> map) throws IOException, InterruptedException {
		readFromMap(map);
	}

	public void readFromMap(Map<String, List<Integer>> map) throws IOException, InterruptedException {
		Student s = new Student();
		readDataFromMap(s, map);
	}

	public void readDataFromMap(Student s, Map<String, List<Integer>> map) throws IOException, InterruptedException {
		char c;
		for (String name : map.keySet()) {
			List<Integer> list = map.get(name);
			s.setMidMarks(list.get(1));
			s.setHomework(list.get(2));
			s.setFinalMarks(list.get(0));
			s.setQuizMarks(list.get(3));
			c = calculateGrade(s);
			writeGradeToFile(name, c);
		}
	}

	public char calculateGrade(Student s) throws IOException {
		char grade;
		double total = 0.2 * s.getMidMarks() + 0.3 * s.getHomework() + 0.4 * s.getFinalMarks() + 0.1 * s.getQuizMarks();
		if (total >= 90)
			grade = 'A';
		else if (total >= 80 && total < 90)
			grade = 'B';
		else if (total >= 70 && total < 80)
			grade = 'C';
		else if (total >= 60 && total < 70)
			grade = 'D';
		else
			grade = 'F';
		return grade;
	}

	public void writeGradeToFile(String name, char grade) throws IOException, InterruptedException {
		File file = new File("C:\\Users\\tankalluri\\eclipse-workspace\\Multithreading\\src\\multithreading\\assignment\\ass6\\q5\\FinalGrades.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		read.lock();
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			bw.write(name + " got grade " + grade);
			bw.newLine();
			bw.close();
		}
		finally {
			read.unlock();
		}
	}
}
