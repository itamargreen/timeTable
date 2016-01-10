package GA;

import java.util.ArrayList;

public class Teacher {
	private int id;// max 20
	private String name;
	private ArrayList<Lesson> teaches = new ArrayList<Lesson>();

	/**
	 * @param id
	 * @param name
	 * @param teaches
	 */
	public Teacher(int id, String name, ArrayList<Lesson> teaches) {
		this.id = id;
		this.name = name;
		this.teaches = teaches;
	}

	public Teacher(int id, Lesson l) {
		this.id = id;
		try {
			this.name = Constants.teacher[this.id];
		} catch (Exception e) {
			System.err.println("hi");
		}
		teaches.add(l);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the teaches
	 */
	public ArrayList<Lesson> getTeaches() {
		return teaches;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param teaches
	 *            the teaches to set
	 */
	public void setTeaches(ArrayList<Lesson> teaches) {
		this.teaches = teaches;
	}

	public ArrayList<Lesson> teachesAtTime(int hour, int day) {
		ArrayList<Lesson> res = new ArrayList<Lesson>();
		for (Lesson l : teaches) {
			if (l.getHour() == hour && l.getDay() == day) {
				res.add(l);
			}
		}
		return res;
	}

}
