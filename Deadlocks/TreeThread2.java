package multithreading.assignment.ass3.q5;

public class TreeThread2 extends Thread {
	
	TreeNode child;
	TreeNode parent;
	public TreeThread2(TreeNode parent,TreeNode child) {
		this.child =child;
		this.parent=parent;
	}

	public void run()
	{
		 synchronized (child) {
	            System.out.println("Thread 2: Holding child...");
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 2: Waiting for parent...");
	            child.setParentOnly(parent);
	            
	            synchronized (parent) {
	               System.out.println("Thread 2: Holding parent & child...");
	               parent.addChildOnly(child);
	            }
	         }
	}
}
