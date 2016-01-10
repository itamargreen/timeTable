package GA2;

public class Population {

	Solution[] individuals;

	/*
	 * Constructors
	 */
	// Create a population
	public Population(int populationSize, boolean initialise) {
		individuals = new Solution[populationSize];
		// Initialise population
		if (initialise) {
			// Loop and create individuals
			for (int i = 0; i < size(); i++) {
				Solution newIndividual = new Solution();
				newIndividual.generateIndiv();
				saveIndividual(i, newIndividual);
			}
		}
	}

	/* Getters */
	public Solution getIndividual(int index) {
		return individuals[index];
	}

	public Solution getFittest() {
		Solution fittest = individuals[0];
		// Loop through individuals to find fittest
		for (int i = 0; i < size(); i++) {
			// System.out.println(getIndividual(i));
			if (fittest.getFitness() <= getIndividual(i).getFitness()) {
				fittest = getIndividual(i);
			}
		}
		return fittest;
	}

	/* Public methods */
	// Get population size
	public int size() {
		return individuals.length;
	}

	// Save individual
	public void saveIndividual(int index, Solution indiv) {
		individuals[index] = indiv;
	}
}