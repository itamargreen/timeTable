package GA;

import java.util.HashMap;

public class Constants {

	public static String[] lessons = { "Math", "Biology", "Physics", "Computers", "OOP", "Chemistry", "Lit.", "Civics",
			"History", "Bible", "Phys lab", "Biotechnology", "Arabic", "Bio lab", "Chemistry lab"
			/**
			 * , "English","lesson17", "lesson18", "lesson19", "lesson20"
			 */
	};

	public static String[] teacher = { "teacher1", "teacher2", "teacher3"
			/**
			 * , "teacher4", "teacher5", "teacher6", "teacher7", "teacher8",
			 * "teacher9", "teacher10", "teacher11", "teacher12", "teacher13",
			 * "teacher14", "teacher15", "teacher16", "teacher17", "teacher18",
			 * "teacher19", "teacher20", "teacher21", "teacher22", "teacher23",
			 * "teacher24", "teacher25", "teacher26", "teacher27", "teacher28",
			 * "teacher29", "teacher30", "teacher31", "teacher32"
			 */
	};

	public static HashMap<String, Integer> perWeek = new HashMap<String, Integer>();

	public static void construct() {
		for (int i = 0; i < lessons.length; i++) {
			switch (lessons[i]) {
			case "Math":
				perWeek.put(lessons[i], 7);
			case "Biology":
				perWeek.put(lessons[i], 4);
			case "Physics":
				perWeek.put(lessons[i], 4);
			case "Bible":
				perWeek.put(lessons[i], 2);
			case "Chemistry":
				perWeek.put(lessons[i], 4);
			case "Phys lab":
				perWeek.put(lessons[i], 2);
				// case "English":
				 perWeek.put(lessons[i], 6);
				 case "Biotechnology":
				 perWeek.put(lessons[i], 10);
			case "OOP":
				perWeek.put(lessons[i], 2);
			case "Computers":
				perWeek.put(lessons[i], 6);
			case "Arabic":
				perWeek.put(lessons[i], 2);
			case "Bio lab":
				perWeek.put(lessons[i], 2);
			case "Chemistry lab":
				perWeek.put(lessons[i], 2);
			case "History":
				perWeek.put(lessons[i], 4);
			case "Civics":
				perWeek.put(lessons[i], 2);
			case "Lit.":
				perWeek.put(lessons[i], 4);
			}
		}
	}
}
