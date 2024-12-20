import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int row = sc.nextInt();
			int column = sc.nextInt();
			char c = sc.next().charAt(0);	
			
			System.out.println(row*column);
			if(c == 'C')
				break;
		
		}
		sc.close();
	}
		
}
