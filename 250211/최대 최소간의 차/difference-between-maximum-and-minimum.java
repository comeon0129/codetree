import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	
	public static int n,k;
	
	public static int[] arr = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int minCost = Integer.MAX_VALUE;
		
		for(int i=1; i<=10000; i++) {
			int cost = 0;
			for(int j=0; j<n; j++) {
				if(arr[j] < i) {
					cost+= i-arr[j];
				}
				else if(arr[j] > i+k) {
					cost+= arr[j]-(i+k);
				}
			}
			minCost = Math.min(minCost, cost);
		}

		System.out.println(minCost);
		
		sc.close();
    }
}