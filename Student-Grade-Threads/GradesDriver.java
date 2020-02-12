package multithreading.assignment.ass2.q2;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.IOException;

public class GradesDriver {

	public static void main(String args[]) throws IOException, InterruptedException {
		for(int i=0;i<32;i++) {
			 new Thread(new StudentThread(Student.nextId++)).start();
		}
			 new Thread(new GraderThread()).start();
	}
}
