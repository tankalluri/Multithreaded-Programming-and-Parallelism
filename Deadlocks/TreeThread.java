package multithreading.assignment.ass3.q5;

public class TreeThread extends Thread {
	
	TreeNode parent;
	TreeNode child;
	public TreeThread(TreeNode parent, TreeNode child) {
		this.parent =parent;
		this.child = child;
	}

	public void run()
	{	
	     synchronized (parent) {
	            System.out.println("Thread 1: Holding parent..");
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 1: Waiting for child...");
	            parent.addChild(child);
	            
	            synchronized (child) {
	               System.out.println("Thread 1: Holding parent and child...");
	               child.setParentOnly(parent);
	            }
	         }
		
		
	}

}

