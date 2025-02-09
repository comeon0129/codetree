import java.util.Scanner;

public class Main {

	public static final int MAX_N = 100;
	public static int n;
	public static int[] arr = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			arr[i] *=2;
			for(int j=0; j<n; j++) {
				int[] remain = new int[n-1];
				int cnt = 0;
				 for(int k = 0; k < n; k++)
	                    if(k != j)
	                        remain[cnt++] = arr[k];
				 int sumDiff = 0;
				 for(int k=0; k<n-2; k++) {
					 sumDiff += Math.abs(remain[k+1]-remain[k]);
				 }
				 minDiff = Math.min(minDiff,sumDiff);
			}
			arr[i] /= 2;
		}
		System.out.println(minDiff);
		
		sc.close();
    }
}
