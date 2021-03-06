package GA2;

import java.util.HashMap;

public class Const {
	public static HashMap<String, Integer> perWeek = new HashMap<String, Integer>();
	public static HashMap<String, Integer> majorsPerWeek = new HashMap<String, Integer>();
	public static int[] maxes = /** day, index, room */
	{ 4, 8, 30 };
	public static String[] lessons = { "Math", "Majors", "Literature", "Civics", "History", "Bible", "English",
			"Sports", "Homeroom" };
	public static String[] teachers = { "Naama Levintal", "Alla Marianovski", "Janna Tzimring", "Dora Zaltzberg",
			"Lowell Blackman", "Neomi Filer", "Avishai", "Moshe Pavlotski", "Dganit", "Liat Gilad Abovich ",
			"Anna Ostrovsky", "Ella Cochavi", "Monica Itah", "Broin Kabakovich", "Levana Steein", "Michal",
			"Neta Barkai", "Greensteein", "Geula Seti", "Estela Gotlieb", "Yakov", "Kira Segel", "Silvio Shtesel",
			"Riki Lifman-Yakov", "Ina", "Yulia Skortovski", "Romi Israeli", "Nana", "Shlomit", "Ronen Miller",
			"Sali Yisaayahu", "Pnina", "Sarah (Chemistry)" };
	public static String[] majors = { "OOP", "Arabics", "Computers", "Models", "Biology", "Chemistry", "Biotechnology",
			"Physics" };
	public static HashMap<String, Integer> roomSpecific = new HashMap<String, Integer>();
	public static HashMap<String, String[]> teachersAndLessons = new HashMap<String, String[]>();

	public static void construct() {

		teachersAndLessons.put("Math", new String[] { "Yulia Skortovski", "Yakov", "Riki Lifman-Yakov", "Kira Segel",
				"Silvio Shtesel", "Estela Gotlieb", "Ina" });
		teachersAndLessons.put("OOP", new String[] { "Alla Marianovski" });
		teachersAndLessons.put("Models", new String[] { "Dganit" });
		teachersAndLessons.put("Computers", new String[] { "Dora Zaltzberg" });
		teachersAndLessons.put("Biology", new String[] { "Liat Gilad Abovich ", "Romi Israeli" });
		teachersAndLessons.put("Physics", new String[] { "Janna Tzimring", "Anna Ostrovsky" });
		teachersAndLessons.put("Phys lab", new String[] { "Janna Tzimring", "Anna Ostrovsky" });
		teachersAndLessons.put("Chemistry",
				new String[] { "Greensteein", "Sarah (Chemistry)", "Rut Valdman", "Miriam" });
		teachersAndLessons.put("Civics", new String[] { "Yoav Katz", "Neomi Filer" });
		teachersAndLessons.put("History",
				new String[] { "Neta Barkai", "Neomi Filer", "Rut Benun", "Yehudit", "Yoav Katz" });
		teachersAndLessons.put("Literature", new String[] { "Neta Barkai", "Yakov", "Naama Levintal" });
		teachersAndLessons.put("Bible", new String[] { "Neta Barkai", "Sarah (Bible)" });
		teachersAndLessons.put("Biotechnology", new String[] { "Liat Gilad Abovich" });
		teachersAndLessons.put("Arabic", new String[] { "Geula Seti", "Sali Yisaayahu" });
		teachersAndLessons.put("Bio lab", new String[] { "Pnina", "Liat Gilad Abovich" });
		teachersAndLessons.put("Chemistry lab", new String[] { "Pnina" });
		teachersAndLessons.put("English",
				new String[] { "Lowell Blackman", "Monica Itah", "Broina Kabakovich", "Levana Steein" });
		teachersAndLessons.put("Sports", new String[] { "Moshe Pavlotski", "Ronen Miller", "Rachel Freibun" });
		teachersAndLessons.put("Homeroom",
				new String[] { "Naama Levintal", "Dora Zaltzberg", "Yehudit", "Ela Hadad", "Yulia Skortovski" });

		roomSpecific.put("Alla Marianovski", 26);
		roomSpecific.put("Dora Zaltzberg", 34);
		roomSpecific.put("Anna Ostrovsky", 23);
		roomSpecific.put("Lowell Blackman", 31);
		roomSpecific.put("Monica Itah", 32);
		roomSpecific.put("Bronia Kabakovich", 30);
		roomSpecific.put("Levana Steein", 16);

		for (int i = 0; i < lessons.length; i++) {
			switch (lessons[i]) {
			case "Math":
				perWeek.put(lessons[i], 7);
			case "Biology":
				perWeek.put(lessons[i], 4);
			case "Bible":
				perWeek.put(lessons[i], 2);
			case "English":
				perWeek.put(lessons[i], 6);
			case "History":
				perWeek.put(lessons[i], 4);
			case "Civics":
				perWeek.put(lessons[i], 2);
			case "Literature":
				perWeek.put(lessons[i], 3);
			case "Sports":
				perWeek.put(lessons[i], 2);
			case "Homeroom":
				perWeek.put(lessons[i], 1);
			}
		}
		for (int i = 0; i < majors.length; i++) {
			switch (majors[i]) {
			case "OOP":
				majorsPerWeek.put(majors[i], 6);
			case "Computers":
				majorsPerWeek.put(majors[i], 4);
			case "Models":
				majorsPerWeek.put(majors[i], 4);
			case "Physics":
				majorsPerWeek.put(majors[i], 5);
			case "Biology":
				majorsPerWeek.put(majors[i], 6);
			case "Biotechnology":
				majorsPerWeek.put(majors[i], 6);
			case "Arabics":
				majorsPerWeek.put(majors[i], 6);
			case "Chemistry":
				majorsPerWeek.put(majors[i], 6);
			}
		}
	}
}