import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
//		int b = sc.nextInt();
		for(int i=1; i<=n-1; i++) {
			if(n % i == 0)
				sum+=i;
		}
		if(sum == n)
			System.out.println("P");
		else
			System.out.println("N");
		sc.close();
	}
		
}
