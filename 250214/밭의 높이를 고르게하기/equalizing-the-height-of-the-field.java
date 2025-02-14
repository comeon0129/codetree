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
		int minCost = Integer.MAX_VALUE;
		for(int i=0; i<=n-t; i++) {
			int curCost = 0;
			for(int j=i; j<i+t; j++) {
				curCost+=cost[j];
			}
			minCost = Math.min(minCost, curCost);
		}
		
		
		System.out.println(minCost);
		
		sc.close();
    }
}
