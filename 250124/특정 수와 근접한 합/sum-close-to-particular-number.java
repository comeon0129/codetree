import java.util.Scanner;


public class Main {
	public static int s,n;
	public static int totSum;
	
	public static int[] arr = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			totSum += arr[i];
		}
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				int curSum= totSum - arr[i] -arr[j];
				int curAns= Math.abs(curSum-s);
				min = Math.min(min, curAns);
			}
		}
		System.out.println(min);
		
		sc.close();
    }
}
