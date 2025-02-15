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
				int temp = tempArr[tempArr[i]];
				if(temp == tempArr[i]) {
					break;
				}
				tempArr[tempArr[i]] = tempArr[i];
				tempArr[i] = temp;
				sum+= tempArr[i];
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
		sc.close();
    }
}