import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c =s.charAt(0);
		if (c=='S')
			System.out.println("Superior");
		else if(c=='A')
			System.out.println("Excellent");
		else if(c=='B')
			System.out.println("Good");
		else if(c=='C')
			System.out.println("Usually");
		else if(c=='D')
			System.out.println("Effort");
		
		else
			System.out.println("Failure");
	}
}
