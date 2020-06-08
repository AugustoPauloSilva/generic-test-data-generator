/**
 * 
 */
package aula_teste;

/**
 * @author Ricardo Vilela
 *
 */

import io.jenetics.Genotype;
import io.jenetics.IntegerChromosome;
import io.jenetics.IntegerGene;
import io.jenetics.Mutator;
import io.jenetics.Phenotype;
import io.jenetics.RouletteWheelSelector;
import io.jenetics.SinglePointCrossover;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.engine.EvolutionStatistics;
import io.jenetics.engine.Limits;

import tests.Tests;

public class GeneticAlgorithm {

	static final int MAX = 100000; 	//Do not edit
	static final int MIN = -100000; //Do not edit
	static final int POPSIZE = 100;
	static final int GENERATIONS = 100;
	static final double MUTATION = 0.1;
	static final double CROSSOVER = 0.8;
	
	
	public static double fitness(Genotype<IntegerGene> testdata) {
		
		
		return new Tests().coverageFaults(testdata);
	}

	static Genotype<IntegerGene> genotype = Genotype.of(
			IntegerChromosome.of(IntegerGene.of(MIN, MAX), IntegerGene.of(MIN, MAX)), 	//Chromosome: Addition
			IntegerChromosome.of(IntegerGene.of(MIN, MAX), IntegerGene.of(MIN, MAX)), 	//Chromosome: Subtraction
			IntegerChromosome.of(IntegerGene.of(MIN, MAX), IntegerGene.of(MIN, MAX)), 	//Chromosome: Multiplication
			IntegerChromosome.of(IntegerGene.of(MIN, MAX), IntegerGene.of(MIN, MAX))); //Chromosome: Division 
	

	public static void main(String[] args) {

		final Engine<IntegerGene, Double> engine = Engine
				.builder(GeneticAlgorithm::fitness, genotype)
				.maximizing()
				.offspringSelector(new RouletteWheelSelector<>())
				.populationSize(POPSIZE)
				.alterers(new Mutator<>(MUTATION), new SinglePointCrossover<>(CROSSOVER))
				.build();

		final EvolutionStatistics<Double, ?> statistics = EvolutionStatistics.ofNumber();
		final Phenotype<IntegerGene, Double> best = 
				engine.stream().limit(
						Limits.byFixedGeneration(GENERATIONS))
				.peek(statistics).collect(EvolutionResult.toBestPhenotype());

		System.out.println(best);
		System.out.println(statistics);
		
	
	}
	


}
