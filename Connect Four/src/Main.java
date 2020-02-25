import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board myGame = new Board();
		
		Player player1 = new Player(1, 'x');
		Player player2 = new Player(2, 'o');
		
		Player.setTurn(player1);
		Player turnOfPlaying = null;
		
		@SuppressWarnings("resource")
		Scanner inp = new Scanner(System.in);
		
		while(1 < 2) {
			
			if(player1.getTurn()) turnOfPlaying = player1;
			if(player2.getTurn()) turnOfPlaying = player2;
			
			System.out.println(myGame.showGrid());
			System.out.println(turnOfPlaying.getName() + ", à votre tour de jouer !");
			
			boolean thisShotWasGood = false;
			while(!thisShotWasGood) {
				int x = -1;
				while(x < 0 || x > myGame.getWidth()-1) {
					System.out.print("Entrez un x : ");
					x = Integer.parseInt(inp.nextLine());
				}
				thisShotWasGood = myGame.action(x, turnOfPlaying);
			}
			
			System.out.println();
			
			Player.rotateTurn(player1, player2);
			
		}
		
		/*System.out.println(myGame.showGrid());
		System.out.println("Victory !");*/

	}

}
