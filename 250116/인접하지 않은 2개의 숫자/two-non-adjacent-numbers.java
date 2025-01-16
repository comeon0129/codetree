import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int n;
	public static int[] arr= new int[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+2; j<n; j++) {
				ans = Math.max(ans, arr[i]+arr[j]);
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}