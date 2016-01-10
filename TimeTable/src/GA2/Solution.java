package GA2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class Solution {
	private int fitness;
	Random r = new Random();
	private TimeSlot[][] slots = new TimeSlot[5][9];
	int free = 0;
	boolean home;
	private HashMap<String, String> teachersAndLessons = new HashMap<String, String>();

	public void generateIndiv() {
		for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots[i].length; j++) {
				int room = r.nextInt(30);
				int subject = r.nextInt(Const.lessons.length);
				String subj = Const.lessons[subject];
				String teach = "";
				int teacher = 0;
				try {
					teacher = r.nextInt(Const.teachersAndLessons.get(subj).length);
					teach = Const.teachersAndLessons.get(subj)[teacher];
				} catch (Exception e) {
					teach = "Your major's teacher";
				}
				if (Math.random() < 0.02 && free < 2) {
					slots[i][j] = TimeSlot.freePeriod(i, j);
					free++;
				} else {
					if (subj != "Math" && subj != "English" && subj != "Homeroom")
						slots[i][j] = new TimeSlot(i, j, room, Const.lessons[subject], teach);
					else if (subj == "Homeroom") {
						slots[i][j] = new TimeSlot(i, j, room, Const.lessons[subject], "Your teacher");
						if (!home)
							home = true;
					} else {
						slots[i][j] = new TimeSlot(i, j, room, Const.lessons[subject], "Your teacher");
					}
				}
				Const.lessons = Const.lessonsWithoutHome;
			}
		}
		Const.lessons = Const.lessonsWith;
	}

	public int getFitness() {
		int res = 0;
		ArrayList<Lesson> pre = new ArrayList<Lesson>();
		HashMap<Lesson, Integer> perWeek = new HashMap<Lesson, Integer>();
		for (int j = 0; j < slots.length; j++) {
			for (int k = 0; k < slots[j].length; k++) {
				try {
					if (slots[j][k].isFree()) {
						// System.out.println("bbooa");
					}
				} catch (Exception e) {
					System.out.println("buu");
				}
				if (k % 2 == 0) {
					pre = slots[j][k].getL();
				} else {
					if (slots[j][k].getL() == pre) {
						res += 5;
					}
				}
				String[] teachers = new String[slots[j][k].getL().size()];
				for (int i = 0; i < slots[j][k].getL().size(); i++) {
					teachers[i] = slots[j][k].getL().get(i).getTeacher();
				}
				res += (!repeat(teachers) ? 5 : 0);
				Integer[] rooms = new Integer[slots[j][k].getL().size()];
				for (int i = 0; i < slots[j][k].getL().size(); i++) {
					rooms[i] = slots[j][k].getL().get(i).getRoom();
				}
				res += (!repeat(rooms) ? 5 : 0);
				for (Lesson l : slots[j][k].getL()) {
					if (Const.teachersAndLessons.containsKey(l.getSubject())) {
						if (contains(Const.teachersAndLessons.get(l.getSubject()), l.getTeacher())) {
							res += 5;
						}
					}
					if (Const.roomSpecific.containsKey(l.getTeacher())) {
						if (Const.roomSpecific.get(l.getTeacher()) == l.getRoom()) {
							res++;
						}
					}
					if (perWeek.containsKey(l)) {
						int count = perWeek.get(l);
						perWeek.remove(l);
						perWeek.put(l, count + 1);

					} else {
						perWeek.put(l, 1);
					}
					if (teachersAndLessons.containsKey(l.getSubject())) {
						if (l.getTeacher() == teachersAndLessons.get(l.getSubject())) {
							res += 5;
						}
					} else {
						teachersAndLessons.put(l.getSubject(), l.getTeacher());
					}
				}
				if (slots[j][k] == after(j, k) && slots[j][k] != before(j, k)) {

					for (Lesson l : slots[j][k].getL()) {
						for (Lesson l1 : after(j, k).getL()) {
							if (l.getRoom() == l1.getRoom())
								res += 5;
						}
					}
				}
			}
		}
		for (Entry<Lesson, Integer> entry : perWeek.entrySet()) {
			if (entry.getKey().getSubject() != "Majors") {
				if (entry.getValue() == Const.perWeek.get(entry.getKey()))
					res += 10;
			} else {
				if (entry.getValue() == Const.majorsPerWeek.get(entry.getKey()))
					res += 10;

			}
		}
		if (perWeek.containsKey("Homeroom")) {
			if (perWeek.get("Homeroom") == 1) {
				res += 20;
			}
		}
		if (lessonCount() == 44) {
			res += 10;
		}
		this.fitness = res;
		return res;
	}

	public boolean contains(Object[] a, Object obj) {
		boolean res = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == obj)
				res = true;
		}
		return res;
	}

	public boolean repeat(Object[] a) {
		boolean duplicates = false;
		for (int j = 0; j < a.length; j++)
			for (int k = j + 1; k < a.length; k++)
				if (k != j && a[k] == a[j])
					duplicates = true;
		return duplicates;
	}

	/**
	 * @return the slots
	 */
	public TimeSlot[][] getSlots() {
		return slots;
	}

	/**
	 * @param slots
	 *            the slots to set
	 */
	public void setSlots(TimeSlot[][] slots) {
		this.slots = slots;
	}

	/**
	 * @param i
	 *            the index
	 * @param slots
	 *            the slots to set
	 */
	public void setSlots(int i, TimeSlot[] slots) {
		this.slots[i] = slots;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots[i].length; j++) {
				res += slots[i][j] + "\t\t\t||";
			}
			res += "\n";
		}
		return res;
	}

	private int lessonCount() {
		int res = 0;
		for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots[i].length; j++) {
				try {
					TimeSlot pointless = slots[i][j];
					res++;
				} catch (Exception e) {
					continue;
				}
			}
		}
		return res;
	}

	private TimeSlot after(int day, int index) {
		if (index != 8) {
			return slots[day][index + 1];
		} else {
			return slots[day][index];
		}
	}

	private TimeSlot before(int day, int index) {
		if (index != 0) {
			return slots[day][index - 1];
		} else {
			return slots[day][index];
		}
	}
}
