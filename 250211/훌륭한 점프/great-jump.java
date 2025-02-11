import java.util.Scanner;

public class Main {
	 
	public static int n,k;
	public static int[] arr = new int[100];

	public static boolean isPossible(int maxVal) {
		int[] availableStones = new int[n];
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] <= maxVal)
				availableStones[cnt++] = i;
		}
		for(int i=1; i< cnt; i++) {
			int dist = availableStones[i] - availableStones[i-1];
			if(dist > k)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int minMax = n;
		for(int i=n; i>=Math.max(arr[0], arr[n-1]); i--) {
			if(isPossible(i)) {
				minMax = Math.min(minMax, i);
			}
		}
		System.out.println(minMax);
	
		sc.close();
    }
}