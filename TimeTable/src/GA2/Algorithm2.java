package GA2;

public class Algorithm2 {
	/* GA parameters */
	private static final double mutationRate = 0.35;
	private static final int tournamentSize = 15;
	private static final boolean elitism = false;
	/* Public methods */

	// Evolve a population
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		// Keep our best individual
		if (elitism) {
			newPopulation.saveIndividual(0, pop.getFittest());
		}

		// Crossover population
		int elitismOffset;
		if (elitism) {
			elitismOffset = 1;
		} else {
			elitismOffset = 0;
		}
		// Loop over the population size and create new individuals with
		// crossover
		for (int i = elitismOffset; i < pop.size(); i++) {
			Solution indiv1 = tournamentSelection(pop);
			Solution indiv2 = tournamentSelection(pop);
			Solution newIndiv = crossover(indiv1, indiv2);
			newPopulation.saveIndividual(i, newIndiv);
		}

		return newPopulation;
	}

	// Crossover individuals
	private static Solution crossover(Solution indiv1, Solution indiv2) {
		Solution newSol = new Solution();

		int start = (int) (Math.random() * (indiv1.getSlots().length * indiv1.getSlots()[0].length));
		int end = (int) (Math.random() * (indiv1.getSlots().length * indiv1.getSlots()[0].length));
		for (int i = 0; i < indiv1.getSlots().length; i++) {
			for (int j = 0; j < indiv1.getSlots()[i].length; j++) {
				if (start < end && i > start && i < end) {
					newSol.setSlots(i, indiv1.getSlots()[i]);
				} else if (start > end) {
					if (!(i < start && i > end)) {
						newSol.setSlots(i, indiv1.getSlots()[i]);
					}
				}
			}
		}
		newSol.generateIndiv();
		newSol.getFitness();
		return newSol;
	}
	// Select individuals for crossover
	private static Solution tournamentSelection(Population pop) {
		// Create a tournament population
		Population tournament = new Population(tournamentSize, false);
		// For each place in the tournament get a random individual
		for (int i = 0; i < tournamentSize; i++) {
			int randomId = (int) (Math.random() * pop.size());
			tournament.saveIndividual(i, pop.getIndividual(randomId));
		}
		// Get the fittest
		Solution fittest = tournament.getFittest();
		return fittest;
	}
}