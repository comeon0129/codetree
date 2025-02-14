import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int n,h,t;
	
	public static int[] cost = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		h = sc.nextInt();
		t = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int height = sc.nextInt();
			cost[i] = Math.abs(h - height);
		}
		Arrays.sort(cost,0,n);
		
		int ans = 0;
		for(int i=0; i<t; i++) {
			ans+=cost[i];
		}
		System.out.println(ans);
		
		sc.close();
    }
}
