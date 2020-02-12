package multithreading.assignment.ass1.q2;
/*
 * Tanmayee Kalluri - 001400957
 */
public class Student {

	String name;
	int id;
	int midMarks;
	int project;
	int finalMarks;
	static int nextId=1;
	double total;
	
	Student(String name, int project, int midMarks, int finalMarks, int id){
		this.project=project;
		this.midMarks=midMarks;
		this.finalMarks=finalMarks;
		this.name=name;
		this.id=id;
	}
	
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
	
	@Override
	public String toString() {
		return "Name:"+name+", Mid Marks:"+midMarks+", Final Marks:"+finalMarks+", Project:"+project;
		
	}
	public char calculateGrade() {
		total =  (0.3*this.getMidMarks())+(03*this.getProject())+(0.4*this.getFinalMarks());
		if(total>=90)
			return 'A';
		else if(total>80 && total<90)
			return 'B';
		else if(total>70 && total<80)
			return 'C';
		else if(total>60 && total<70)
			return 'D';
		else
			return 'F';
	}
}
