package multithreading.assignment.ass6.q5;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class GradesDriver {

	public static void main(String args[]) throws IOException, InterruptedException {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i=0;i<50;i++) {
			executor.execute(new StudentThread(Student.nextId++, map));
		}
		executor.execute(new GraderThread(map));
		executor.execute(new StudentThread());
		executor.shutdown();
	}
}
