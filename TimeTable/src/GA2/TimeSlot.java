package GA2;

import java.util.ArrayList;

public class TimeSlot {
	private int day, index;
	private boolean free;
	private ArrayList<Lesson> l = new ArrayList<Lesson>();

	/**
	 * @param day
	 * @param index
	 * @param room
	 * @param teacher
	 * @param subject
	 */
	public TimeSlot(int day, int index, Lesson l) {
		this.day = day;
		this.index = index;
		this.l.add(l);
	}

	public TimeSlot(int day, int index, Lesson l, boolean free) {
		this.day = day;
		this.index = index;
		this.l.add(l);
		this.free = free;
	}

	public TimeSlot(int day, int index, int room, String subject, String teacher) {
		this(day, index, new Lesson(teacher, subject, room));
	}

	public TimeSlot(int day, int index, int room, String subject, String teacher, boolean free) {

		this(day, index, new Lesson(teacher, subject, room), free);
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the l
	 */
	public ArrayList<Lesson> getL() {
		return l;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @param l
	 *            the l to set
	 */
	public void setL(ArrayList<Lesson> l) {
		this.l = l;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "day=" + day + ", index=" + index + "," + l + "";
	}

	public static TimeSlot freePeriod(int day, int index) {
		return new TimeSlot(day, index, -1, "null", "null", true);
	}

	/**
	 * @return the free
	 */
	public boolean isFree() {
		return free;
	}
	
}
