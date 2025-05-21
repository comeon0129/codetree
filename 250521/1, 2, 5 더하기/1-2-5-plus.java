import java.util.Scanner;

public class Main {
	public static int n; 
	public static int[] numbers = new int[3];
	public static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 5;
		
		dp = new int[n+1];
		
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=2; j++) {
				if(i>= numbers[j]) {
					dp[i] = (dp[i]+ dp[i-numbers[j]]) % 10007;
				}
			}
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}