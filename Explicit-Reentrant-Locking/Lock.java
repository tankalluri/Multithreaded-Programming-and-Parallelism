package multithreading.assignment.ass4.q6;

public class Lock {

	boolean isLocked = false;
	Thread lockedBy = null;
	int lockedCount = 0;

	public synchronized void lock() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		System.out.println("Number of locks open at the beginning-> "+lockedCount);
		while (isLocked && lockedBy != callingThread || lockedCount>1) {
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = callingThread;
		System.out.println("Number of locks open at the end-> "+lockedCount);
	}

	public synchronized void unlock() {
		if (Thread.currentThread() == this.lockedBy) {
			lockedCount--;
			System.out.println("Number of locks closed at the end-> "+lockedCount);

			if (lockedCount == 0) {
				isLocked = false;
				notify();
			}
		}
	}
}
