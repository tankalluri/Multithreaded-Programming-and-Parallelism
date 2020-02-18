package socket;
/*
 * Tanmayee Kalluri - 001400957
 */
public class ClientDriver {
	public static void main(String args[]) {
		for (int i = 0; i < 50; i++) {
		new Thread(new StudentClient()).start();
		}
	}
}
