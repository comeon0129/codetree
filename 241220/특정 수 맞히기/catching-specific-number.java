import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int num = sc.nextInt();
			if(num< 25)
				System.out.println("Higher");
			else if(num > 25)
				System.out.println("Lower");
			else {
				System.out.println("Good");
				break;
			}
		}
	
		sc.close();
	}
		
}



