package socket;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StudentClient implements Runnable {
	Student s = new Student();

	static int generateFinalMarks(Random rand, Student s) {
		int val = rand.nextInt(70 + 1) + 30;
		s.setFinalMarks(val);
		return val;
	}

	static int generateHomework(Random rand, Student s) {
		int val = rand.nextInt(70 + 1) + 30;
		s.setHomework(val);
		return val;
	}

	static int generateMidMarks(Random rand, Student s) {
		int val = rand.nextInt(70 + 1) + 30;
		s.setMidMarks(val);
		return val;
	}

	static int generateQuizMarks(Random rand, Student s) {
		int val = rand.nextInt(70 + 1) + 30;
		s.setQuizMarks(val);
		return val;
	}

	@Override
	public void run() {
		Map<Integer, Map<String, Integer>> smap = new HashMap<>();
		try (var socket = new Socket("localhost", 59898)) {
			synchronized (socket) {
					Map<String, Integer> map = new HashMap<>();
					Random rand = new Random();
					s.setName("Student" + Student.id);
					Thread.sleep(1000);
					map.put("final", generateFinalMarks(rand, s));
					Thread.sleep(1000);
					map.put("mid", generateMidMarks(rand, s));
					Thread.sleep(1000);
					map.put("homework", generateHomework(rand, s));
					Thread.sleep(1000);
					map.put("quiz", generateQuizMarks(rand, s));
					smap.put(Student.id++, map);
			}

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(smap);
			System.out.println("Client->" + smap);

			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			Map<Integer, Character> m = (Map<Integer, Character>) objectInputStream.readObject();
			for (int name : m.keySet()) {
				System.out.println("Student " + name + " got grade " + m.get(name));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
