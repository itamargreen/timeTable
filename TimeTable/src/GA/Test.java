package GA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Test {

	static int numOfSubj = 4;
	static int numOfTeachers = 2;
	static int dayNum = 3;
	static int roomNum = 4;
	static int hourNum = 3;
	static int numOfGroups = 2;
	public static int[] max = { numOfSubj, dayNum, hourNum, roomNum, numOfTeachers, numOfGroups };
	
	public static void main(String[] args) {
		/**
		 * assigning teachers to lessons and vice versa 
		 */
		
		
		
		Population pop = new Population(50, true);
		// Evolve population for 100 generations
		pop = Algorithm.evolvePopulation(pop);
		for (int i = 0; i < 100; i++) {
			pop = Algorithm.evolvePopulation(pop);
		}
		System.out.println("Finished");
		System.out.println("Solution:");
		Individual selected = pop.getFittest();

		hour[] hours = new hour[9];

		for (int i = 0; i < selected.getLessons().length; i++) {
			Lesson l = selected.getLessons()[i];
			hours[l.getHour()] = new hour(l.getRoom(), l.getTeacher().getName());
		}
		day sunday = new day(hours, 0);
		System.out.println(sunday);


		System.out.println("1");
		for (int i = 0; i < selected.getLessons().length; i++) {
			Lesson temp = selected.getLessons()[i];
			if (temp.getDay() == 0) {
				System.out.println(temp.getName() + ": at " + temp.getHour() + " in " + temp.getRoom() + " by "
						+ temp.getTeacher().getName());
			}
		}
		System.out.println("2");
		for (int i = 0; i < selected.getLessons().length; i++) {
			Lesson temp = selected.getLessons()[i];
			if (temp.getDay() == 1) {
				System.out.println(temp.getName() + ": at " + temp.getHour() + " in " + temp.getRoom() + " by "
						+ temp.getTeacher().getName());
			}
		}
		System.out.println("3");
		for (int i = 0; i < selected.getLessons().length; i++) {
			Lesson temp = selected.getLessons()[i];
			if (temp.getDay() == 2) {
				System.out.println(temp.getName() + ": at " + temp.getHour() + " in " + temp.getRoom() + " by "
						+ temp.getTeacher().getName());
			}
		}
		System.out.println("4");
		for (int i = 0; i < selected.getLessons().length; i++) {
			Lesson temp = selected.getLessons()[i];
			if (temp.getDay() == 3) {
				System.out.println(temp.getName() + ": at " + temp.getHour() + " in " + temp.getRoom() + " by "
						+ temp.getTeacher().getName());
			}
		}
		System.out.println("5");
		for (int i = 0; i < selected.getLessons().length; i++) {
			Lesson temp = selected.getLessons()[i];
			if (temp.getDay() == 4) {
				System.out.println(temp.getName() + ": at " + temp.getHour() + " in " + temp.getRoom() + " by "
						+ temp.getTeacher().getName());
			}
		}

		for (Entry<String, Integer> entry : selected.getLessonsOfType().entrySet()) {
			System.out.println(entry.getKey() + " counts: " + entry.getValue());
		}
	}

}

class record {
	public int room;
	public String teacher;

	public record(int room, String teacher) {
		this.room = room;
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Room " + room + " - " + teacher;
	}
}

class day {
	public hour[] hours = new hour[9];
	public String indentation;

	public day(hour[] hours, int indentation) {
		this.hours = hours;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indentation; i++) {
			sb.append("\t");
		}
		this.indentation = sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hours.length; i++) {
			sb.append(indentation + "Hour " + i + " - " + hours[i] + "\n");
		}
		return sb.toString();
	}
}

class hour {
	public ArrayList<record> lessons = new ArrayList<record>();

	public hour(int room, String teacher) {
		lessons.add(new record(room, teacher));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (record r : lessons) {
			sb.append(r + "\n");
		}
		return sb.toString();
	}
}

