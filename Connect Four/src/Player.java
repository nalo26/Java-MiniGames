
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
	
	public int getPlayer() {
		return this.n;
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
