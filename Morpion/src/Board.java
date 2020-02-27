
public class Board {
	
	public static final int SIZE = 3;
	
	private final Slot[][] slots;
	private final int size;

	public Board() {
		this.size = SIZE;
		this.slots = new Slot[this.size][this.size];
		for(int i=0; i<this.slots.length; i++) {
			for(int j=0; j<this.slots[i].length; j++) {
				this.slots[i][j] = new Slot(i*SIZE+(j+1));
			}
		}
	}
	
	public String showGrid() {
		String res = "";
		
		for(int i=0; i<this.slots.length; i++) {
			res += "| ";
			for(int j=0; j<this.slots[i].length; j++) {
				if(this.slots[i][j].getChar() == ' ') res += this.slots[i][j].getValue() + " | ";
				else res += this.slots[i][j].getChar() + " | ";
			}
			res += "\n";
		}
		
		return res;
	}

	public int getSize() {
		return (int)Math.pow(this.size, 2);
	}

	public boolean action(int x, Player p) {
		int temp = 0;
		while(x > this.size) {
			x -= this.size;
			temp += 1;
		}
		if(this.slots[temp][x-1].getChar() != Slot.VOID) return false;
		else {
			this.slots[temp][x-1].change(p);
			return true;
		}
	}

	public int isEnd(Player p1, Player p2){
		for(int i=0; i<this.size; i++) {
			if(this.slots[i][0].getChar() == this.slots[i][1].getChar() && this.slots[i][1].getChar() == this.slots[i][2].getChar() && this.slots[i][0].getChar() != Slot.VOID) return Player.getPlayer(p1, p2, this.slots[i][0].getChar());
			if(this.slots[0][i].getChar() == this.slots[1][i].getChar() && this.slots[1][i].getChar() == this.slots[2][i].getChar() && this.slots[0][i].getChar() != Slot.VOID) return Player.getPlayer(p1, p2, this.slots[0][i].getChar());
		}
		
		if(this.slots[0][2].getChar() == this.slots[1][1].getChar() && this.slots[1][1].getChar() == this.slots[2][0].getChar() && this.slots[0][2].getChar() != Slot.VOID) return Player.getPlayer(p1, p2, this.slots[0][2].getChar());
		if(this.slots[0][0].getChar() == this.slots[1][1].getChar() && this.slots[1][1].getChar() == this.slots[2][2].getChar() && this.slots[0][0].getChar() != Slot.VOID) return Player.getPlayer(p1, p2, this.slots[0][0].getChar());
		
		for(Slot[] w : this.slots) {
			for(Slot h : w) {
				if(h.getChar() == Slot.VOID) return 0; // some case are still empty
			}
		}		
		
		return -1; //Equality (no more case)
	}
	
}
