import java.util.HashMap;
import java.util.Map;

public class Calculator {
	private int state = 0;


	private Map<String, Integer> memory= new HashMap<>();


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setMemory(String key, Integer value ) {
		this.memory.putIfAbsent(key, value);
	}

	public int getMemory(String key) { return memory.get(key);}

	public void add(int value) {
		long test = (long)state + value;
		if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
			throw new NumberFormatException("Overflow.");
		}
		else {state += value;}
	}

	public void add(int value, String key){
		this.add(value);
		this.setMemory(key, this.state);

	}

	public void add(String ing1, String ing2, String sum){
		int i = this.getMemory(ing1) + this.getMemory(ing2);
		this.setMemory(sum,i);
	}

	public void mult(int value){
			long test = (long)state * value;
			if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
				throw new NumberFormatException("Overflow.");
			}
			else {state *= value;}
		}

	public void mult(int value, String key) {
		this.mult(value);
		this.setMemory(key, getState());
	}

	public void mult(String ing1, String ing2, String sum){
		int i = this.getMemory(ing1) * this.getMemory(ing2);
		this.setMemory(sum,i);
	}

	public void sub(int value) {
		long test = (long) state - value;
		if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
			throw new NumberFormatException("Overflow.");
		} else {
			state -= value;
		}
	}

	public void sub(int value, String key) {
		this.sub(value);
		this.setMemory(key, this.state);
	}

	public void sub(String ing1, String ing2, String sum){
		int i = this.getMemory(ing1) - this.getMemory(ing2);
		this.setMemory(sum,i);
	}

	public void div(int value) {
		if (value == 0) {
			throw new IllegalArgumentException("You can't dived by 0.");
		} else {
			state /= value;
		}
	}

		public void div(int value, String key) {
			this.div(value);
			this.setMemory(key, this.state);
		}

	public void div(String ing1, String ing2, String sum){
		int i = this.getMemory(ing1) / this.getMemory(ing2);
		this.setMemory(sum,i);
	}







}
