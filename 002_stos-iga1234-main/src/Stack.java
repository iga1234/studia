import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stack {
	private int [] elements = new int[0];

	public void push(int element){
		int x = elements.length;
		elements = Arrays.copyOf(elements, x + 1);
		elements[x] = element;
	}
	public int pop(){
		int x = elements.length;
		if (x == 0) {
			throw new NoSuchElementException("Stack is empty.");
		}
		int n = elements[elements.length - 1];
		elements = Arrays.copyOf(elements, x - 1);
		return n;
	}

	public int peek(){
		int x = elements.length;
		if (x == 0) {
			throw new NoSuchElementException("Stack is empty.");
		}
		return elements[x - 1];
	}
}
