package GA;

public class Lesson {
	private int day;// 3
	private int hour;// 5
	private Teacher teacher;
	private StudentGroup group;
	private String name;
	private int lessons;
	private boolean must;
	private int id;
	private int room;

	/**
	 * @param day
	 * @param hour
	 * @param teacher
	 * @param students
	 * @param name
	 * @param id
	 */
	public Lesson(int day, int hour, Teacher teacher, StudentGroup students, String name, int id, int room) {
		this.day = day;
		this.hour = hour;
		this.teacher = teacher;
		this.group = students;
		this.name = name;
		this.room = room;
		this.id = id;

		this.group.addLesson(this);
		if (!this.teacher.getTeaches().contains(this)) {
			this.teacher.getTeaches().add(this);
		}

	}

	public Lesson() {

	}

	public Lesson(String gene) {
		fromGene(gene);
	}

	public void fromGene(String gene) {
		int[] max = Test.max;
		String curr = "";
		String dayString = gene.substring(0, max[1]);
		curr += dayString;
		String hourString = gene.substring(curr.length(), max[2] + 3);
		curr += hourString;
		String roomString = gene.substring(curr.length(), max[3] + 6);
		curr += roomString;
		String teacherID = gene.substring(curr.length(), max[4] + 10);
		curr += teacherID;
		String group = gene.substring(curr.length(), max[5] + 12);
		curr += group;
		String idString = gene.substring(curr.length(), gene.length());
		curr += idString;
		this.id = Integer.parseInt(idString, 2);
		this.day = Integer.parseInt(dayString, 2);
		this.hour = Integer.parseInt(hourString, 2);
		this.room = Integer.parseInt(roomString, 2);
		this.name = Constants.lessons[id];
		this.teacher = new Teacher(Integer.parseInt(teacherID, 2), this);
		this.group = new StudentGroup(Integer.parseInt(group, 2), this);
	}

	public String toGene() {
		String res = "";
		return res;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @return the groups
	 */
	public StudentGroup getGroups() {
		return group;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @param teacher
	 *            the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @param groups
	 *            the groups to set
	 */
	public void setGroups(StudentGroup groups) {
		this.group = groups;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	public static Lesson generate() {
		Lesson l = new Lesson();
		int rand = (int) Math.random() * Constants.lessons.length;
		String name = Constants.lessons[rand];
		l.name = name;
		String[] names = Constants.teachersAndLessons.get(name);
		rand = (int) Math.random() * names.length;
		l.teacher = Constants.teachers.get(names[rand]);
		for (String s : Constants.must) {
			if (s == name)
				l.must = true;
		}
		l.lessons = Constants.perWeek.get(names);
		return l;

	}
}
