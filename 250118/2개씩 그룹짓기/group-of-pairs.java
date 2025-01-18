import java.util.Scanner;
import java.util.Arrays;


public class Main {

	public static final int INT_MIN = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[2*n];
	
		for(int i=0; i<2*n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int max = INT_MIN;
		
		for(int i=0; i<n; i++) {
			if(arr[i]+ arr[2*n-i-1] > max) {
				max = arr[i] + arr[2*n-i-1];
			}
		}
		
		
		System.out.println(max);
		
		sc.close();
    }
}