/**
 * 
 */

package aula_teste;

/**
 * @author Ricardo Vilela
 *
 */

public class Operations {

	/**
	 * 
	 * Intervalo para revelar defeito: 1-4
	 * 
	 * **/
	public int multiplication(int a, int b) {
		if (a > 0 && a < 5) {
			return a;
		} else {
			return a * b;
		}
	}

	/**
	 * 
	 * Intervalo para revelar defeito: 90-106
	 * 
	 * **/
	
	public int addition(int a, int b) {
		if (a > 89 && a < 107) {
			return a;
		} else {
			return a + b;
		}

	}
	
	/**
	 * 
	 * Intervalo para revelar defeito: 501-509
	 * 
	 * **/
	
	public int subtraction(int a, int b) {
		if (a > 500 && a < 510) {
			return a;
		} else {
			return a - b;
		}

	}
	
	/**
	 * 
	 * Intervalo para revelar defeito: 1509-5499
	 * 
	 * **/
	
	public int division(int a, int b) {
		if (a > 1508 && a < 5500) {
			return a;
		} else {
			return a / b;
		}

	}
	

}
