
public class Player {

	private final String name;
	private final int n;
	private final char sign;
	private boolean itTurn;
	
	public Player(int n, char s) {
		this.name = "Joueur " + n;
		this.n = n;
		this.itTurn = false;
		this.sign = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static int getPlayer(Player p1, Player p2, char c) {
		if(p1.getSign() == c) return p1.n;
		if(p2.getSign() == c) return p2.n;
		
		return -1;
	}
	
	public char getSign() {
		return this.sign;
	}
	
	public boolean getTurn() {
		return this.itTurn;
	}

	public static void setTurn(Player p) {
		p.itTurn = true;
	}
	
	public static void rotateTurn(Player p1, Player p2) {
		if(p1.itTurn) {
			p1.itTurn = false;
			setTurn(p2);
		}
		else {
			p2.itTurn = false;
			setTurn(p1);
		}
	}
}
