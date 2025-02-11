import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 1000;
	
	public static int n;
	
	public static int[] hills = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			hills[i] = sc.nextInt();
		}
		
		int minCost = Integer.MAX_VALUE;
		
		for(int h=0; h<=83; h++) {
			int cost = 0;
			for(int i=0; i<n; i++) {
				if(hills[i] < h) {
					cost += (h-hills[i])*(h-hills[i]);
				}
				else if(hills[i] > h+17) {
					cost+= (hills[i]-(h+17))*(hills[i]-(h+17));
				}
			}
			minCost = Math.min(minCost, cost);
		}
		System.out.println(minCost);
		
		sc.close();
    }
}
