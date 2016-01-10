package GA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Constants {

	public static String[] lessons = { "Math", "Biology", "Physics", "Computers", "OOP", "Chemistry", "Lit.", "Civics",
			"History", "Bible", "Phys lab", "Biotechnology", "Arabic", "Bio lab", "Chemistry lab", "English", "Sports",
			"Models", "Homeroom" };

	public static String[] teacher = { "Naama", "Alla", "Janna", "Dora", "Lowell", "Neomi", "Avishai", "Moshe",
			"Dganit", "Liat", "Anna", "Ella Cochavi", "Monica", "Bronia", "Levana", "Michal", "Neta", "Feia", "Geula",
			"Estela", "Yakov", "Kira", "Silvio", "Riki", "Ina", "Yulia", "Romi", "Nana", "Shlomit", "Ronen", "Sali",
			"Pnina", "Sarah" };

	public static HashMap<String, Integer> perWeek = new HashMap<String, Integer>();

	public static HashMap<String, String[]> teachersAndLessons = new HashMap<String, String[]>();
	public static HashMap<String, Teacher> teachers = new HashMap<String, Teacher>();
	public static String[] must = { "Math", "Lit.", "History", "Civics", "Bible", "English", "Homeroom" };

	public static void construct() {

		teachersAndLessons.put("Math", new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("OOP", new String[] { "Alla" });
		teachersAndLessons.put("Models", new String[] { "Dganit" });
		teachersAndLessons.put("Computers", new String[] { "Dganit", "Dora", "Alla" });
		teachersAndLessons.put("Biology", new String[] { "Liat" });
		teachersAndLessons.put("Physics", new String[] { "Janna", "Anna" });
		teachersAndLessons.put("Chemistry", new String[] { "Feia", "Sarah", "Rut (Chemistry)", "Miriam" });
		teachersAndLessons.put("Civics", new String[] { "Yoav", "Neomi" });
		teachersAndLessons.put("History",
				new String[] { "Neta", "Neomi", "Rut (History)", "Yehudit", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Lit.", new String[] { "Neta", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Bible", new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Biotechnology",
				new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Arabic", new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Bio lab", new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Chemistry lab",
				new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("English", new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Sports", new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
		teachersAndLessons.put("Homeroom",
				new String[] { "Yulia", "Yakov", "Riki", "Kira", "Silvio", "Estela", "Ina" });
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
			case "English":
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
				perWeek.put(lessons[i], 3);
			case "Sports":
				perWeek.put(lessons[i], 2);
			case "Models":
				perWeek.put(lessons[i], 2);
			case "Homeroom":
				perWeek.put(lessons[i], 1);
			}
		}
	}
}
