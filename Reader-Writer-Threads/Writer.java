package multithreading.assignment.ass1.q4;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.util.logging.Level;
import java.util.logging.Logger;

class Writer implements Runnable {

	ReaderWriterThread readWriteThread;

   int counter = 1;

   public Writer(ReaderWriterThread readWriteThread) {
       this.readWriteThread = readWriteThread;
   }

   @Override
   public void run() {
       synchronized(readWriteThread) {
           System.out.println("Writer thread->" + Thread.currentThread().getName());
           while(ReaderWriterThread.list.size()!=0) {
               try {
                   Thread.sleep(1000);
                   readWriteThread.wait();
               } catch (InterruptedException ex) {
                   Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           for(int i = 0; i<10; i++) {
        	   ReaderWriterThread.list.add(counter++);
           }
           readWriteThread.m1();
           readWriteThread.notifyAll();
       }
   }
}
