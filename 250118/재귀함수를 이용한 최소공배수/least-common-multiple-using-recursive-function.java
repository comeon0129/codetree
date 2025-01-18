import java.util.Scanner;

public class Main {

	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
	
	public static int lcm(int[] arr, int n) {
		for(int i=0; i<n-1; i++) {
			arr[i+1] = arr[i] * arr[i+1] / gcd(arr[i], arr[i+1]);
		}
		return arr[n-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
	
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = lcm(arr,n);
		
		System.out.println(ans);
		
		sc.close();
    }
}