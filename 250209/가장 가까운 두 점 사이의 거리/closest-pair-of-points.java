import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n;
	
	public static int[] x = new int[MAX_N];
	public static int[] y = new int[MAX_N];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int dist = ((x[i]-x[j])*(x[i]-x[j])) + ((y[i]-y[j])*(y[i]-y[j]));
				ans = Math.min(ans, dist);
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}