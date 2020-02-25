
public class Slot {
	
	public static final char VOID = ' ';
	private char content;

	public Slot() {
		this.content = VOID;
	}
	
	public void change(Player p) {
		this.content = p.getSign();
	}
	
	public char getChar() {
		return this.content;
	}

}
