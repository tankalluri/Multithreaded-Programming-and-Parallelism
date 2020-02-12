package multithreading.assignment.ass3.q3;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradesDriver {

	public static void main(String args[]) throws IOException, InterruptedException {
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i=0;i<50;i++) {
			 new Thread(new StudentThread(Student.nextId++, map)).start();
		}
			 new Thread(new GraderThread(map)).start();
			 new Thread(new StudentThread()).start();
	}
}
