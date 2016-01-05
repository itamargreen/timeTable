package GA;

import java.util.ArrayList;

public class StudentGroup {
	private int id;// max 7
	private ArrayList<Lesson> attends = new ArrayList<Lesson>();
	//private ArrayList<Student> students = new ArrayList<Student>();

	/**
	 * @param id
	 * @param attends
	 */
	public StudentGroup(int id, ArrayList<Lesson> attends) {
		this.id = id;
		this.attends = attends;
	}

	public StudentGroup(int id, Lesson l) {
		this.id = id;
		this.attends.add(l);
		//constructGroup(this, l);
	}
//
//	public void constructGroup(StudentGroup group, Lesson l) {
//		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
//		String line = "";
//		while ((line = reader.readLine()) != null) {
//			Student student = new Student();
//		}
//	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the attends
	 */
	public ArrayList<Lesson> getAttends() {
		return attends;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param attends
	 *            the attends to set
	 */
	public void setAttends(ArrayList<Lesson> attends) {
		this.attends = attends;
	}

	public void addLesson(Lesson l) {
		this.attends.add(l);
	}

}
