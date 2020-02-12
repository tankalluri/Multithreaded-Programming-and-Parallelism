package multithreading.assignment.ass3.q5;

public class TestDriver {

		public static TreeNode parent = new TreeNode();
		public static TreeNode child = new TreeNode();
		 public static void main(String args[]) {
		      new TreeThread(parent,child).start();
		       new TreeThread2(parent,child).start();
		 }
	}
