import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		int n = sc.nextInt();
		for(int i=n; i<=100; i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		sc.close();
	}
		
}



