import java.util.Scanner;

public class Main {
	
	public static int n;
	public static final int MAX_N = 1000;
	public static int[] arr = new int[MAX_N];
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans =1;
		int curCnt = 1;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n-1; i++) {
			if(arr[i] < arr[i+1]) {
				curCnt ++;
				ans = Math.max(ans, curCnt);
			}
			else{
				ans = Math.max(ans,curCnt);
				curCnt = 1;
			}
		}
		System.out.println(ans);	
		
		sc.close();
    }
}