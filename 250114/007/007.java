import java.util.Scanner;

class Secret{
	String code; 
	char place; 
	int time;
	
	public Secret(String code, char place, int time) {
		this.code = code;
		this.place = place;
		this.time = time;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = sc.next().charAt(0);
		int t = sc.nextInt();
		Secret p = new Secret(s,c,t);
		System.out.println("secret code : "+p.code);
		System.out.println("meeting point : "+p.place);
		System.out.println("time : "+p.time);
		
		
		sc.close();
    }
}