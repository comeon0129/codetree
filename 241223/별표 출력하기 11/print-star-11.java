import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for(int i=0; i<=2*n; i++) {
			for(int j=0; j<=2*n; j++) {
				if(i % 2 != 0 && j % 2 !=0)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	
		sc.close();
	}
		
}


