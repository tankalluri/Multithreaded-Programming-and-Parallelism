package multithreading.assignment.ass2.q3;
/*
 * Tanmayee Kalluri - 001400957
 */
public class TestSynchronization2 {
	public static void main(String args[]) {
		Table obj1 = new Table();// only one object
		Table obj2 = new Table();// only one object

		MyThread1 t1 = new MyThread1(obj1);
		MyThread2 t2 = new MyThread2(obj2);
		t1.start();
		t2.start();
	}
}
