package multithreading.assignment.ass1.q7;
/*
 * Tanmayee Kalluri - 001400957
 */
public class MyThread implements Runnable{

    Input ip;
    Object lock;

    public MyThread(Input ip, Object lock){
        this.ip = ip;
        this.lock = lock;
    }

    @Override
    public void run() {
        int index = -1;     
        while((index=ip.getIndex())!=-1){
            synchronized(lock) {
                	System.out.println(
					Thread.currentThread().getName());               	
                	ip.print(index);
            }
        }
    }   
}
