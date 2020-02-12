package multithreading.assignment.ass1.q8;
/*
 * Tanmayee Kalluri - 001400957
 */
public class Data {
    private String packet;
    private boolean transfer = true;
    public synchronized void send(String packet) {
        while (!transfer) {
            try { 
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.out.println("Thread interrupted"+ e); 
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }
  
    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.out.println("Thread interrupted"+ e); 
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    } 
    }

