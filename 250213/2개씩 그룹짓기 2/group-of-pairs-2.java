import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100000;
	
	public static int n;
	
	public static int[] arr = new int[MAX_N *2];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<2*n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr,0,2*n);
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			ans = Math.min(ans, arr[i+n] - arr[i]);
		}
		System.out.println(ans);
		sc.close();
    }
}