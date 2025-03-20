package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;

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
	public void testDivByZero() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.div(0);
		assertEquals("1 / 0 = 1 (nie zmieniamy wartości przez error)", 1, sut.getState());
	}
}
