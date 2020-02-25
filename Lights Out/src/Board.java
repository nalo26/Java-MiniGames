
public class Board {

	
	private static final int DEFAULT_W = 5;
	private static final int DEFAULT_H = 5;
	private static final int MAX_W = 10;
	private static final int MAX_H = 10;
	private final int w;
	private final int h;
	
	public final Tild[][] tilds;

	public Board(int w, int h) {
		if(w < MAX_W) this.w = w;
		else this.w = MAX_W;
		if(h < MAX_H) this.h = h;
		else this.h = MAX_H;
		this.tilds = new Tild[this.h][this.w];
		
		for(int i = 0; i<tilds.length; i++) {
			for(int j = 0; j<tilds[i].length; j++) {
				tilds[i][j] = new Tild();
			}
		}
		
	}
	
	public Board() {
		this(DEFAULT_W, DEFAULT_H);
	}
	
	public int getWidth() {
		return this.w;
	}
	public int getHeight() {
		return this.h;
	}
	
	public String showGrid() {
		String res = "  x ";
		
		for(int i = 0; i<this.w; i++) res += i + " ";
		res += "\ny  ";
		for(int i = 0; i<this.w*2; i++) res += "-";
		res += "\n";
		
		for(int i = 0; i<tilds.length; i++) {
			res += i + " | ";
			for(int j = 0; j<tilds[i].length; j++) {
				res += tilds[i][j].toString() + " ";
			}
			res += "\n";
		}
		
		return res;
	}

	public boolean isVictory() {
		for(Tild[] w : this.tilds) {
			for(Tild h : w) {
				if(!h.getState()) return false;
			}
		}
		return true;
	}

	public void action(int x, int y) {
		this.tilds[y][x].switchState();
		if(x > 0) this.tilds[y][x-1].switchState();
		if(x < this.w-1) this.tilds[y][x+1].switchState();
		if(y > 0) this.tilds[y-1][x].switchState();
		if(y < this.h-1) this.tilds[y+1][x].switchState();
	}
	
}
