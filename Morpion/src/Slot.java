
public class Slot {
	
	public static final char VOID = ' ';
	private char content;
	private final int value;

	public Slot(int i) {
		this.content = VOID;
		this.value = i;
	}
	
	public void change(Player p) {
		this.content = p.getSign();
	}
	
	public char getChar() {
		return this.content;
	}

	public int getValue() {
		return this.value;
	}
	
}
