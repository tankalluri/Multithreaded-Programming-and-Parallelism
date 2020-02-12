package multithreading.assignment.ass2.q3;
/*
 * Tanmayee Kalluri - 001400957
 */
class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}
}
