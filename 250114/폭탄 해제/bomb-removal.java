import java.util.Scanner;

class Bomb {
	String code;
	char color;
	int second;
	
	public Bomb(String code,char color,int second) {
		this.code = code;
		this.color =color;
		this.second = second;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = sc.next();
		char color = sc.next().charAt(0);
		int second = sc.nextInt();
		Bomb b = new Bomb(code,color,second);
		System.out.println("code : "+b.code);
		System.out.println("color : "+b.color);
		System.out.println("second : "+b.second);
		
		sc.close();
    }
}