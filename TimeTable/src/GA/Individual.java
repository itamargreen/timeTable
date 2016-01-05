package GA;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import ext.binRelated;

public class Individual {
	Random rand = new Random();
	static int defaultGeneLength = 40;
	private String[] genes = new String[defaultGeneLength];
	// Cache
	private int fitness = 0;
	private Lesson[] lessons = new Lesson[defaultGeneLength];
	HashMap<String, Integer> lessonsOfType = new HashMap<String, Integer>();

	// Create a random individual
	public void generateIndividual(boolean create) {
		for (int i = 0; i < size(); i++) {
			String gene = "";
			String day = resize(binNumber(5), Test.max[1]);
			// 3
			String hour = resize(binNumber(binRelated.maxNumForLength(Test.max[2])), Test.max[2]);
			// 6
			String room = resize(binNumber(binRelated.maxNumForLength(Test.max[3])), Test.max[3]);
			// 10
			String teacher = resize(binNumber(binRelated.maxNumForLength(Test.max[4])), Test.max[4]);
			// 12
			String groups = resize(binNumber(binRelated.maxNumForLength(Test.max[5])), Test.max[5]);
			// 18
			String id = resize(binNumber(binRelated.maxNumForLength(Test.max[0])), Test.max[0]);
			gene = day + hour + room + teacher + groups + id;
			genes[i] = gene;
			lessons[i] = new Lesson(gene);
		}
	}

	public String binNumber(int length) {
		Random rg = new Random();
		int n = rg.nextInt(length);
		return Integer.toBinaryString(n);
	}

	public String resize(String str, int length) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		for (int i = 0; i < length - str.length(); i++) {
			sb.append("0");
		}
		sb.reverse();
		str = sb.toString();
		return str;
	}

	private double evaluate() {
		double res = 0;
		int[] lessonsPerDay = new int[5];

		for (Lesson l : lessons) {
			if (lessonsOfType.containsKey(l.getName())) {
				int curr = lessonsOfType.get(l.getName());
				lessonsOfType.replace(l.getName(), curr + 1);
			} else {
				lessonsOfType.put(l.getName(), 1);
			}

			lessonsPerDay[l.getDay()]++;
			if (l.getHour() + 9 > 9 && l.getHour() + 9 < 16) {
				res++;
			}
			if (l.getTeacher().teachesAtTime(l.getHour(), l.getDay()).size() == 1)
				res++;
		}
		for (Entry<String, Integer> entry : lessonsOfType.entrySet()) {
			if (entry.getValue() == Constants.perWeek.get(entry.getKey()))
				res++;
		}
		for (int i = 0; i < lessonsPerDay.length; i++) {
			res += (lessonsPerDay[i] == 9) ? 1 : 0;
		}
		return res;
	}

	/* Getters and setters */
	// Use this if you want to create individuals with different gene lengths
	public static void setDefaultGeneLength(int length) {
		defaultGeneLength = length;
	}

	public String getGene(int index) {
		return genes[index];
	}

	public void setGene(int index, String value) {
		genes[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int size() {
		return genes.length;
	}

	public double getFitness() {
		if (fitness == 0) {
			fitness = (int) evaluate();
		}
		return fitness;
	}

	@Override
	public String toString() {
		String geneString = fitness + ": ";
		for (int i = 0; i < size(); i++) {
			geneString += genes[i];
		}
		return geneString;
	}

	public boolean hasGene(String gene) {
		for (int i = 0; i < this.genes.length; i++) {
			if (getGene(i) == gene)
				return true;
		}
		return false;
	}

	/**
	 * @return the lessons
	 */
	public Lesson[] getLessons() {
		return lessons;
	}

	public HashMap<String, Integer> getLessonsOfType() {
		return lessonsOfType;
	}

}