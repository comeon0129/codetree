import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	
		int mul = 1;
		for(int i=1; i<=n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			mul=1;
			for(int j=a; j<=b; j++) {
				mul*=j;
			}
			System.out.println(mul);
		}
			
		sc.close();
	}
		
}