package multithreading.assignment.ass2.q3;
/*
 * Tanmayee Kalluri - 001400957
 */
class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}
