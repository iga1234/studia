import org.junit.*;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class StackTest {
	@Test
	public void testPopAfterPush() {
		Stack stack = new Stack();
		stack.push(10);
		int result = stack.pop();

		assertEquals("pop after push", 10, result);
	}

	@Test
	public void testPeekAfterPush() {
		Stack stack = new Stack();
		stack.push(15);
		int result = stack.peek();

		assertEquals("peek after push", 15, result);
	}

	@Test
	public void testPopAfterTwoPush() {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(5);
		int result = stack.pop();

		assertEquals("pop after two push", 5, result);
	}

	@Test
	public void testPeekAfterTwoPush() {
		Stack stack = new Stack();
		stack.push(15);
		stack.push(10);
		int result = stack.peek();

		assertEquals("peek after two push", 10, result);
	}

	@Test
	public void testTwoPop() {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		int result = stack.pop();

		assertEquals("first pop ", 20, result);
		int result2 = stack.pop();
		assertEquals("second pop", 10, result2);
	}

	@Test(expected = NoSuchElementException.class)
	public void testPopAndEmptyPop() {
		Stack stack = new Stack();
		stack.push(10);
		int result = stack.pop();

		assertEquals("first pop ", 10, result);
		stack.pop();

	}

	@Test(expected = NoSuchElementException.class)
	public void testPopEmptyStack() {
		Stack stack = new Stack();
		stack.pop();
	}

	@Test(expected = NoSuchElementException.class)
	public void testPeekEmptyStack() {
		Stack stack = new Stack();
		stack.peek();
	}

	@Test
	public void testPeek() {
		Stack stack = new Stack();
		stack.push(10);
		int result = stack.peek();

		assertEquals("peek after push", 10, result);
	}

	@Test
	public void testPeekAfterPeek() {
		Stack stack = new Stack();
		stack.push(10);
		int result = stack.peek();

		assertEquals("peek after push", 10, result);
		int result2 = stack.peek();

		assertEquals("peek2 the same like peek", result, result2);
	}
}
