package multithreading.assignment.ass4.q6;


public class Reentrant2 extends Thread{
	Lock lock;
	
	Reentrant2() throws InterruptedException{
		 lock = new Lock();
		 outer();
	}
	Reentrant2(int r) throws Exception{
		lock = new Lock();
		inner();
	}

	public void outer() throws InterruptedException {
       lock.lock();
       System.out.println("In outer");
       System.out.println("Calling inner...");
       inner();
       lock.unlock();
    }

	public synchronized void inner() throws InterruptedException{
       lock.lock();
       //do something
       System.out.println("In inner");
       lock.unlock();
    }
	
	public static void main(String args[]) throws Exception {
		Thread t1 = new Thread(new Reentrant2());
		t1.start();
		new Thread(new Reentrant2(3)).start();
	}
}
