package multithreading.assignment.ass1.q2;
import java.util.*;
/*
 * Tanmayee Kalluri - 001400957
 */
public class TestDriver {

	public static void main(String[] args) {
		Random rand = new Random();
		for( int i = 1; i<= 25; i++ ) {
			int finalMarks =(int) rand.nextInt(50+1)+50;
			int project = (int) rand.nextInt(50+1)+50;
			int midMarks  = (int) rand.nextInt(50+1)+50;
			
			Student s = new Student("Student"+Student.nextId++, project, midMarks, finalMarks, i);
			s.calculateGrade();
			String val = s.toString();
			System.out.println(val+", Grade:"+s.calculateGrade());
		}
	}
}
