
public class Tild {
	
	private boolean state;

	public Tild() {
		this.state = false;
	}

	public void switchState() {
		this.state = !this.state;
	}
	
	public String toString() {
		if(this.state) return "o";
		else return "x";
	}

	public boolean getState() {
		return this.state;
	}
	
}
