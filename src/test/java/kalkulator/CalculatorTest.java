package kalkulator;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testAddNeg() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.add(-1);
		assertEquals("1+(-1) = 0", 0, sut.getState());
	}

	@Test
	public void testMultOneByNeg() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(-1);
		assertEquals("1*(-1) = -1", -1, sut.getState());
	}

	@Test
	public void testMultOneByZero() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(0);
		assertEquals("1*0 = 0", 0, sut.getState());
	}

	@Test
	public void testSubOne() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.sub(1);
		assertEquals("1-1 = 0", 0, sut.getState());
	}

	@Test
	public void testSubNeg() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.sub(-1);
		assertEquals("1-(-1) = 2", 2, sut.getState());
	}

	@Test
	public void testDivTenByTwo() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.div(2);
		assertEquals("10 / 2 = 5", 5, sut.getState());
	}

	@Test
	public void testDivTenByNeg() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.div(-2);
		assertEquals("10 / (-2) = -5", -5, sut.getState());
	}

	@Test
	public void testSaveMemory() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.saveMem(); // zawiera 1
		assertEquals("Memory: 1", 1, sut.getMem());
	}

	@Test
	public void testUseMemory() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.saveMem(); // zawiera 1
		sut.useMem(); // dodaje 1
		assertEquals("1 +(M 1) = 2", 2, sut.getState());
	}

	@Test
	public void testAddMemory(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.addMem();
		assertEquals("(M 0)+1 = (M 1)", 1, sut.getMem());
	}

	@Test
	public void testSubMemory(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.subMem();
		assertEquals("(M 0)-1 = (M -1)", -1, sut.getMem());
	}

	@Test
	public void testDivByZero() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.div(0);
        assertTrue("1 / 0 = err", sut.getError());
	}

	@Test
	public void testWielomian(){
			int[] tablica = new int[6];
		Calculator sut = new Calculator();
		int[] x = {-3, -2, -1, 1, 2, 3};
		for (int i = 0; i < x.length; i++) {
			sut.setState(x[i]);
			sut.power(5);
			sut.saveMem();

			sut.setState(x[i]);
			sut.power(4);
			sut.mult(4);
			sut.addMem();

			sut.setState(x[i]);
			sut.power(3);
			sut.mult(3);

			sut.addMem();

			sut.setState(x[i]);
			sut.power(2);
			sut.mult(2);
			sut.subMem();

			sut.setState(17);
			sut.addMem();

			int licznik = sut.getMem();

			sut.setState(x[i]);
			sut.power(2);
			sut.saveMem();

			sut.setState(x[i]);
			sut.mult(-7);
			sut.addMem();

			sut.setState(1);
			sut.addMem();

			int mianownik = sut.getMem();

			sut.setState(licznik);
			sut.div(mianownik);

			int wynik = sut.getState();

			tablica[i] = wynik;
		}
		assertEquals(Arrays.toString(new int[]{0, 0, 1, -4, -14, -58}), Arrays.toString(tablica));
	}
}

// wielomian = (x^5 + 4x^4 + 3x^3 - 2x^2 + 17) / (x^2 -7x + 1)
// kalkulator online: ~0, ~0, ~1, ~-4, ~-14, ~-58