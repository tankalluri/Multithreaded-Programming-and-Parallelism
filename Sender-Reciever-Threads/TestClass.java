package multithreading.assignment.ass1.q8;
/*
 * Tanmayee Kalluri - 001400957
 */
public class TestClass {
	public static void main(String s[]) {
		Data data = new Data();
	    Thread sender = new Thread(new Sender(data));
	    Thread receiver = new Thread(new Receiver(data));
	     
	    sender.start();
	    receiver.start();
	}
}
