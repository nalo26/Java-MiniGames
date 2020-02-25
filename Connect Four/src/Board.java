
public class Board {
	
	public static final int DEFAULT_W = 7;
	public static final int DEFAULT_H = 6;
	
	private final Slot[][] slots;
	private final int w;
	private final int h;

	public Board() {
		this.w = DEFAULT_W;
		this.h = DEFAULT_H;
		this.slots = new Slot[this.h][this.w];
		for(int i=0; i<this.slots.length; i++) {
			for(int j=0; j<this.slots[i].length; j++) {
				this.slots[i][j] = new Slot();
			}
		}
	}
	
	public String showGrid() {
		String res = " ";
		for(int i=0; i<this.w; i++) res += i + " ";
		res += "\n";
		for(int i=0; i<this.w; i++) res += " v";
		res += "\n";
		
		for(int i=0; i<this.slots.length; i++) {
			res += "|";
			for(int j=0; j<this.slots[i].length; j++) {
				res += this.slots[i][j].getChar() + "|";
			}
			res += "\n";
		}
		res += "-";
		for(int i=0; i<this.w; i++) res += "--";
		
		return res;
	}

	public int getWidth() {
		return this.w;
	}

	public boolean action(int x, Player p) {
		int i = this.h-1;
		if(this.slots[0][x].getChar() != Slot.VOID) return false;
		while(this.slots[i][x].getChar() != Slot.VOID && i != -1) {
			i--;
		}
		this.slots[i][x].change(p);
		return true;
	}
	
}
