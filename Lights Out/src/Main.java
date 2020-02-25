import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board myGame = new Board(); // You can set a size here
		
		Scanner inp = new Scanner(System.in);
		
		while(!myGame.isVictory()) {
			System.out.println(myGame.showGrid());
			int x = -1, y = -1;
			while(x < 0 || x > myGame.getWidth()-1) {
				System.out.print("Entrez un x : ");
				x = Integer.parseInt(inp.nextLine());
			}
			while(y < 0 || y > myGame.getHeight()-1) {
				System.out.print("Entrez un y : ");
				y = Integer.parseInt(inp.nextLine());
			}
			System.out.println();
			
			myGame.action(x, y);
		}
		
		System.out.println(myGame.showGrid());
		System.out.println("Victory !");
		
	}

}
