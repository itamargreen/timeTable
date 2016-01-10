package GA2;

public class Lesson {
	private String teacher, subject;
	private int room;

	/**
	 * @param teacher
	 * @param subject
	 */
	public Lesson(String teacher, String subject, int room) {
		this.teacher = teacher;
		this.subject = subject;
		this.room = room;
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param teacher
	 *            the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "teacher=" + teacher + ",subject=" + subject + ",room=" + room + "";
	};

}
