package multithreading.assignment.ass2.q2;
/*
 * Tanmayee Kalluri - 001400957
 */
public class Student {

	String name;
	int id;
	int midMarks;
	int project;
	int finalMarks;
	static int nextId = 1;
	double total;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMidMarks() {
		return midMarks;
	}
	public void setMidMarks(int midMarks) {
		this.midMarks = midMarks;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public int getFinalMarks() {
		return finalMarks;
	}
	public void setFinalMarks(int finalMarks) {
		this.finalMarks = finalMarks;
	}
	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Student.nextId = nextId;
	}
}
