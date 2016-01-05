package GA;

public class Algorithm {

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
			Individual indiv1 = tournamentSelection(pop);
			Individual indiv2 = tournamentSelection(pop);
			Individual newIndiv = crossover(indiv1, indiv2);
			newPopulation.saveIndividual(i, newIndiv);
		}

		// Mutate population
		for (int i = elitismOffset; i < newPopulation.size(); i++) {
			mutate(newPopulation.getIndividual(i));
		}

		return newPopulation;
	}

	// Crossover individuals
	private static Individual crossover(Individual indiv1, Individual indiv2) {
		Individual newSol = new Individual();
		int start = (int) (Math.random() * indiv1.size());
		int end = (int) (Math.random() * indiv1.size());
		for (int i = 0; i < indiv1.size(); i++) {
			if (start < end && i > start && i < end) {
				newSol.setGene(i, indiv1.getGene(i));
			} else if (start > end) {
				if (!(i < start && i > end)) {
					newSol.setGene(i, indiv1.getGene(i));
				}
			}
		}
		for (int i = 0; i < indiv2.size(); i++) {
			// If child doesn't have the city add it
			if (!newSol.hasGene(indiv2.getGene(i))) {
				// Loop to find a spare position in the child's tour
				for (int ii = 0; ii < newSol.size(); ii++) {
					// Spare position found, add city
					
					if ("null" == newSol.getGene(ii)) {
						newSol.setGene(ii, indiv2.getGene(i));
						break;
					}
				}
			}
		}
		newSol.generateIndividual(false);
		newSol.getFitness();
		return newSol;
	}

	// Mutate an individual
	private static void mutate(Individual indiv) {
		// Loop through genes
		for (int i = 0; i < indiv.size(); i++) {
			if (Math.random() < mutationRate) {
				char[] nums = indiv.getGene(i).toCharArray();
				for (char c : nums) {
					if (c == '1')
						c = '0';
					else
						c = '1';
				}
				String gene = String.valueOf(nums);
				indiv.setGene(i, gene);
			}
		}
	}

	// Select individuals for crossover
	private static Individual tournamentSelection(Population pop) {
		// Create a tournament population
		Population tournament = new Population(tournamentSize, false);
		// For each place in the tournament get a random individual
		for (int i = 0; i < tournamentSize; i++) {
			int randomId = (int) (Math.random() * pop.size());
			tournament.saveIndividual(i, pop.getIndividual(randomId));
		}
		// Get the fittest
		Individual fittest = tournament.getFittest();
		return fittest;
	}
}