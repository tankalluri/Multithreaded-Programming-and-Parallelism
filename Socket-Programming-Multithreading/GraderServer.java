package socket;

/*
 * Tanmayee Kalluri - 001400957
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class GraderServer {

	public static void main(String[] args) throws Exception {
		try (var listener = new ServerSocket(59898)) {
			System.out.println("The capitalization server is running...");
			var pool = Executors.newFixedThreadPool(20);
			while (true) {
				pool.execute(new Capitalizer(listener.accept()));
			}
		}
	}

	private static class Capitalizer implements Runnable {
		private Socket socket;

		Capitalizer(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			char grade;
			System.out.println("Connected: " + socket);
			try {
				Map<Integer, Character> gradeMap = new HashMap<>();
				InputStream inputStream = socket.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				Map<Integer, Map<String, Integer>> map = (Map<Integer, Map<String, Integer>>) objectInputStream
						.readObject();
				System.out.println("Server->" + map);
				for (int name : map.keySet()) {
					Map<String, Integer> m = map.get(name);
					m.get("mid");
					grade = calculateGrade(m.get("quiz"), m.get("homework"), m.get("final"), m.get("mid"));
					writeToFile(name, grade);
					gradeMap.put(name, grade);
				}
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				objectOutputStream.writeObject(gradeMap);
			} catch (Exception e) {
				System.out.println("Error:" + socket);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
				}
				System.out.println("Closed: " + socket);
			}
		}

		static char calculateGrade(int quiz, int homework, int finals, int mid) {
			char grade;
			double total = 0.2 * mid + 0.3 * homework + 0.4 * finals + 0.1 * quiz;
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

		static void writeToFile(int name, char grade) throws IOException {
			File file = new File("C:\\Users\\tankalluri\\eclipse-workspace\\Multithreading\\src\\socket\\Grade");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			try {
				if (!file.exists()) {
					file.createNewFile();
				}
				bw.write(name + " got grade " + grade);
				bw.newLine();
				bw.close();
			} finally {
			}
		}
	}
}
