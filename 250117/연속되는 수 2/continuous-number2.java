import java.util.Scanner;

public class Main {
	
	public static int n;
	public static final int MAX_N = 1000;
	public static int[] arr = new int[MAX_N+1];
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans = 0;
		int cur_cnt = 1;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n-1; i++) {
			if(arr[i] != arr[i+1]) {
				ans = Math.max(ans, cur_cnt);
				cur_cnt = 1;
				continue;
			}
			cur_cnt++;
		}
		System.out.println(ans);
		sc.close();
    }
}