import java.util.Scanner;

public class Main {
	public static int n,m;
	
	public static int[] numbers = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int total =0;
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
			total += numbers[i];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				int sum1 = 0;
				int sum2 = 0;
				for(int k=0; k<=i; k++) {
					sum1+=numbers[k];
				}
				for(int k=i+1; k<=j; k++) {
					sum2+= numbers[k];
				}
				int sum3 = total-(sum1+sum2);
				int maxSum = Math.max(sum1, Math.max(sum2, sum3));
				ans = Math.min(ans, maxSum);
			}
		}
		System.out.println(ans);
		sc.close();
    }
}