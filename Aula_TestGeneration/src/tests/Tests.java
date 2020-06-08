/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import aula_teste.Operations;
import io.jenetics.Genotype;
import io.jenetics.IntegerGene;

/**
 * @author Ricardo Vilela
 *
 */
public class Tests {

	@Test
	public double coverageFaults(Genotype<IntegerGene> testdata) {
		double coverage = 0;
		Operations tester = new Operations();

		/**
		 * Verify Addition
		 **/
		int a = testdata.get(0).get(0).intValue(); // Genotype.Chromosome.Gene.intValue
		int b = testdata.get(0).get(1).intValue();

		try {
			assertEquals(a + b, tester.addition(a, b));
		} catch (AssertionError e) {
			coverage += 25;
		}

		/**
		 * Verify Subtraction
		 **/
		a = testdata.get(1).get(0).intValue(); // Genotype.Chromosome.Gene.intValue
		b = testdata.get(1).get(1).intValue();

		try {
			assertEquals(a - b, tester.subtraction(a, b));
		} catch (AssertionError e) {
			coverage += 25;
		}

		/**
		 * Verify Multiplication
		 **/
		a = testdata.get(2).get(0).intValue(); // Genotype.Chromosome.Gene.intValue
		b = testdata.get(2).get(1).intValue();

		try {
			assertEquals(a * b, tester.multiplication(a, b));
		} catch (AssertionError e) {
			coverage += 25;
		}

		/**
		 * Verify Divison
		 **/
		a = testdata.get(2).get(0).intValue(); // Genotype.Chromosome.Gene.intValue
		b = testdata.get(2).get(1).intValue();

		try {
			assertEquals(a - b, tester.divison(a, b));
		} catch (AssertionError e) {
			coverage += 25;
		}

		return coverage;
	}

}
