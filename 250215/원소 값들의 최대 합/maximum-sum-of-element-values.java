import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static final int  MAX_N = 100;
	
	public static int[] arr = new int[MAX_N+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			int[] tempArr = arr.clone();
			int sum = 0;
			for(int j=0; j<m; j++) {
				sum += tempArr[i];
				int temp = tempArr[tempArr[i]];
				tempArr[tempArr[i]] = tempArr[i];
				tempArr[i] = temp;
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
		sc.close();
    }
}
