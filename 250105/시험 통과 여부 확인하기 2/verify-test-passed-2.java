import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int pass = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<4; j++) {
				sum+=sc.nextInt();
			}
			double ans = (double)sum/4;
			if(ans >=60) {
				System.out.println("pass");
				pass++;
			}
			else
				System.out.println("fail");
		}
		System.out.println(pass);
		
		sc.close();
	}
		
}