package controlador;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	private static Calculadora calc;

	@BeforeAll
	static void inicializarCalculadora() {
		 calc = new Calculadora();
	}
	
	@Test
	void sumaTest() {
		assertEquals(8, calc.suma(1, 7), "Error al sumar 1+7");
		assertEquals(-3, calc.suma(9, -12), "Error al sumar 9+-12");
	}
	
	@Test 
	void divideTest() {
		assertEquals(2, calc.divide(4, 2));
		assertEquals(0.5, calc.divide(2, 4));
		assertEquals(0, calc.divide(4, 0));
	}
	@Test
	void esParTest() {
		assertAll(
		()->assertTrue(calc.esPar(8), "El número debe devolver true"),
		()->assertTrue(calc.esPar(-6), "El número debe devolver true"),
		()->assertFalse(calc.esPar(5), "El número debe devolver false"),
		()->assertFalse(calc.esPar(-13), "El número debe devolver false"),
		()->assertTrue(calc.esPar(0), "El número debe devolver true")
		);
	}
	@Test
	void getEstadoIMCTest() {
		
		assertEquals("Bajo peso", calc.getEstadoIMC(15), "Debe devolver Bajo Peso");
		assertEquals("Peso normal (saludable)", calc.getEstadoIMC(20), "Debe devolver Peso normal (saludable)");
		assertEquals("Sobrepeso", calc.getEstadoIMC(27.47f), "Debe devolver Sobrepeso");
		assertEquals("Obesidad premórbida", calc.getEstadoIMC(35f), "Debe devolver Obesidad premórbida");
		assertEquals("Obesidad mórbida", calc.getEstadoIMC(46f), "Debe devolver Obesidad mórbida");
		
		//casos límite
		assertEquals("Bajo peso", calc.getEstadoIMC(0), "Debe devolver Bajo Peso");
		assertEquals("Peso normal (saludable)", calc.getEstadoIMC(18.5f), "Debe devolver Peso normal (saludable)");
		assertEquals("Sobrepeso", calc.getEstadoIMC(24.9f), "Debe devolver Sobrepeso");
		assertEquals("Obesidad premórbida", calc.getEstadoIMC(29.9f), "Debe devolver Obesidad premórbida");
		assertEquals("Obesidad mórbida", calc.getEstadoIMC(40f), "Debe devolver Obesidad mórbida");
	}
	
	@Test
	void esPrimoTest() {

		assertFalse(calc.esPrimo(0), "El número debe devolver false");
		assertTrue(calc.esPrimo(1), "El número debe devolver true");
		assertTrue(calc.esPrimo(2), "El número debe devolver true");
		assertTrue(calc.esPrimo(-2), "El número debe devolver true");
		assertFalse(calc.esPrimo(4), "El número debe devolver false");
		assertFalse(calc.esPrimo(-4), "El número debe devolver false");	
	}
	@Test
	void factorialTest() {
		assertEquals(120, calc.factorial(5), "Debe devolver 120");
		assertEquals(1, calc.factorial(1), "Debe devolver 1");
		assertEquals(1, calc.factorial(0), "Debe devolver 1");
		assertThrows(ArithmeticException.class, ()->calc.factorial(-5));
	}
	@Test
	void rotarDerechaTest() {
		//hay que crear primero los vectores 
		int v[]= {1,2,3,4,5};
		int rotado[]= {5,1,2,3,4};
		calc.rotarDerecha(v);
		assertArrayEquals("El vector rotado debe ser {5,1,2,3,4}", rotado, v);
	}
	
	
}
