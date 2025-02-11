import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static final int MAX_N = 1000;
	
	public static int n,k;
	
	public static int[] arr =new int[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr,0,n);
		int maxCnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(arr[j]-arr[i]<=k)
					maxCnt = Math.max(maxCnt, j-i+1);
			}
		}
		System.out.println(maxCnt);
		sc.close();
    }
}