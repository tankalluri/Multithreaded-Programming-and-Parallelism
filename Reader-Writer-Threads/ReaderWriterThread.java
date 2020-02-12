package multithreading.assignment.ass1.q4;
/*
 * Tanmayee Kalluri - 001400957
 */
import java.util.ArrayList;
import java.util.List;

public class ReaderWriterThread {

   public static List<Integer> list = new ArrayList<>();

   public void m1() {
       System.out.println("Method m1 -> " +Thread.currentThread().getName());
   }

   public static void main(String[] args) {
	   ReaderWriterThread readwrite = new ReaderWriterThread();
       Thread reader1 = new Thread(new Reader(readwrite));
       Thread reader2 = new Thread(new Reader(readwrite));
       Thread reader3 = new Thread(new Reader(readwrite));
       Thread reader4 = new Thread(new Reader(readwrite));
       Thread writer = new Thread(new Writer(readwrite));

       reader1.start();
       reader2.start();
       reader3.start();
       reader4.start();
       writer.start();
   }
}
