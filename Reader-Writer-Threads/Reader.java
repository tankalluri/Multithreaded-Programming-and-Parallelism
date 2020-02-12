package multithreading.assignment.ass1.q4;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.util.logging.Level;
import java.util.logging.Logger;

class Reader implements Runnable {

	ReaderWriterThread readWrite;

   public Reader(ReaderWriterThread readWrite) {
       this.readWrite = readWrite;
   }

   @Override
   public void run() {
       synchronized(readWrite) {
           while(ReaderWriterThread.list.size() == 0) {
               try {
                   System.out.println(Thread.currentThread().getName() + " Reader is waiting");
                   readWrite.wait();
               } catch (InterruptedException ex) {
                   Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           readWrite.m1();
           System.out.println(Thread.currentThread().getName() + " Reader->" +ReaderWriterThread.list);
       }
   }

}

