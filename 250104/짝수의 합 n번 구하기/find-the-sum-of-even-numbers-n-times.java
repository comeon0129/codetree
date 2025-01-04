import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int even = 0;
			for(int j=a; j<=b; j++) {
				if(j % 2 == 0) {
					even+=j;
				}
			}
			System.out.println(even);
		}
		
		
		
		sc.close();
	}
		
}
