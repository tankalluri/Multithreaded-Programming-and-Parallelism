package multithreading.assignment.ass6.q5;
/*
 * Tanmayee Kalluri - 001400957
 */
public class Student {

	String name;
	int id;
	int midMarks;
	int homework;
	int finalMarks;
	public int getQuizMarks() {
		return quizMarks;
	}
	public void setQuizMarks(int quizMarks) {
		this.quizMarks = quizMarks;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	int quizMarks;
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
	public int getHomework() {
		return homework;
	}
	public void setHomework(int homework) {
		this.homework = homework;
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
