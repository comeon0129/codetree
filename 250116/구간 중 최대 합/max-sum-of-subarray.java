import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int n;
	public static int k;
	public static int[] arr= new int[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans =0;
		for(int i=0; i<=n-k; i++) {
			int sum =0; 
			for(int j=i; j<i+k; j++) {
				sum+= arr[j];
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
		
		sc.close();
    }
}