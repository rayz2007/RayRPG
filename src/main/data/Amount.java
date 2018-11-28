package main.data;
/**
 * Represents the part (amount) and boundaries of a
 * special attribute, like a progress bar.
 * 
 * @author Ray
 *
 */
public class Amount {
	private int max;
	private int actual_value;	
	

	public Amount(int max, int actual_value) throws Exception {
		setMax(max);
		setActual_value(actual_value);
	}

	public void setMax(int max) {
		this.max = max;
	}
	public void setActual_value(int actual_value) throws Exception {
		if (actual_value < 0 || actual_value > this.max) {
			throw new Exception("actual value must be >= 0 && <= this.max!\n");
		}
		this.actual_value = actual_value;
	}
	
	public int getMax() {
		return max;
	}
	public int getActual_value() {
		return actual_value;
	}
	
}
