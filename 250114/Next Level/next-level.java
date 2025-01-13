import java.util.Scanner;

class Game {
	String id;
	int level;
	
	Game(){
		this.id = "codetree";
		this.level = 10;
	}
	Game(String id, int level){
		this.id = id;
		this.level = level;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		int level = sc.nextInt();
		Game g1=new Game();
		Game g2=new Game(id,level);
		System.out.println("user "+g1.id+" lv "+g1.level);
		System.out.println("user "+g2.id+" lv "+g2.level);
		
		
		sc.close();
    }
}