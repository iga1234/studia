import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private Calculator sut;
	
	@Before
	public void setUp(){
		sut = new Calculator();
	}
	
	@Test
	public void testAddOne() {
		// Arrange
		// sut = System Under Test
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testAddMinusFour() {
		sut.add(-4);
		assertEquals("0+(-4)= ", -4, sut.getState());
	}

	@Test
	public void testAddMinusOneToMinusOne() {
		sut.setState(-1);
		sut.add(-1);
		assertEquals("-1+(-1)= ", -2, sut.getState());
	}

	@Test(expected = NumberFormatException.class)
	public void testAddMaxInteger() {
		sut.setState(Integer.MAX_VALUE);
		sut.add(1);
	}

	@Test(expected = NumberFormatException.class)
	public void testAddMinInteger() {
		sut.setState(Integer.MIN_VALUE);
		sut.add(-1);
	}

	@Test
	public void testAddToMemory() {
		sut.add(3, "a");
		assertEquals(sut.getMemory("a"),3);

	}

	@Test
	public void testAddRememberValues() {
		sut.setMemory("a", 4);
		sut.setMemory("b", 2);
		sut.add("a","b","c");
		assertEquals(sut.getMemory("c"),6);
	}

	@Test
	public void testMultOneByTwo() {
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testMultMinusOneByMinusTwo() {
		sut.setState(-1);
		sut.mult(-2);
		assertEquals("-1*(-2) = 2", 2, sut.getState());
	}

	@Test
	public void testMultMinusOneByTwo() {
		sut.setState(-1);
		sut.mult(2);
		assertEquals("-1*2 = -2", -2, sut.getState());
	}

	@Test
	public void testMultZeroByOne() {
		sut.mult(1);
		assertEquals("0*1 = 0", 0, sut.getState());
	}

	@Test(expected = NumberFormatException.class)
	public void testMultMaxInteger() {
		sut.setState(Integer.MAX_VALUE);
		sut.add(2);
	}

	@Test(expected = NumberFormatException.class)
	public void testMultMinInteger() {
		sut.setState(Integer.MIN_VALUE);
		sut.add(-2);
	}

	@Test
	public void testMultToMemory() {
		sut.setState(2);
		sut.mult(10, "c");
		assertEquals(sut.getMemory("c"), 20);
	}

	@Test
	public void testMultRememberValues() {
		sut.setMemory("a", 2);
		sut.setMemory("b", 4);
		sut.mult("a","b","c");
		assertEquals(sut.getMemory("c"),8);
	}

	@Test
	public void testSubMinusOne() {
		sut.sub(-1);
		assertEquals("0-(-1) = 1", 1, sut.getState());
	}

	@Test
	public void testSubTwo() {
		sut.sub(2);
		assertEquals("0-2 = -2", -2, sut.getState());
	}

	@Test
	public void testSubMinusOneAndTwo() {
		sut.setState(-1);
		sut.sub(2);
		assertEquals("-1-2 = -3", -3, sut.getState());
	}

	@Test
	public void testSubToMemory() {
		sut.sub(3, "b");
		assertEquals(sut.getMemory("b"), -3);
	}

	@Test
	public void testSubRememberValues() {
		sut.setMemory("a", 1);
		sut.setMemory("b", 2);
		sut.sub("a","b","c");
		assertEquals(sut.getMemory("c"),-1);
	}

	@Test
	public void testDivFourByTwo() {
		sut.setState(4);
		sut.div(2);
		assertEquals("4/2 = 2 ", 2, sut.getState());
	}

	@Test
	public void testDivMinusTwoByOne() {
		sut.setState(-4);
		sut.div(1);
		assertEquals("-4/1 = -4 ", -4, sut.getState());
	}

	@Test
	public void testDivMinusTwoByMinusOne() {
		sut.setState(-2);
		sut.div(-1);
		assertEquals("-2/(-1) = 2 ", 2, sut.getState());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDevByZero() {
		sut.setState(-2);
		sut.div(0);
	}

	@Test
	public void testDivMemory() {
		sut.setState(10);
		sut.div(2, "a");
		assertEquals(sut.getMemory("a"), 5);
	}

	@Test
	public void testDivRememberValues() {
		sut.setMemory("a", 8);
		sut.setMemory("b", 2);
		sut.div("a","b","c");
		assertEquals(sut.getMemory("c"),4);
	}

	@Test
	public void testAddMemoryResults() {
		int expected = 16;
		sut.setMemory("a", 4);
		sut.setMemory("b", 2);
		sut.add("a", "b", "c");
		sut.add(10, "d");

		sut.add("c", "d", "sum");
		int actual = sut.getMemory("sum");

		assertEquals(expected, actual);
	}




}
