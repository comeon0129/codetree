import java.util.Scanner;


public class Main {
	
	public static final int MAX_N = 1000000;
	
	public static int n,m;
	
	public static int[] a = new int[MAX_N+1];
	public static int[] b = new int[MAX_N+1];
	public static int[] top = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int a_idx = 1;
		int b_idx = 1;
		int totalTime = 0;
		
		for(int i=0; i<n; i++) {
			int v = sc.nextInt();
			int t = sc.nextInt();
			for(int j=0; j<t; j++) {
				a[a_idx] = a[a_idx-1]+v;
				a_idx++;
			}
			totalTime+=t;
		}
		for(int i=0; i<m; i++) {
			int v = sc.nextInt();
			int t = sc.nextInt();
			for(int j=0; j<t; j++) {
				b[b_idx] = b[b_idx-1]+v;
				b_idx++;
			}
		}
		
		for(int i=1; i<=totalTime; i++) {
			if(a[i] > b[i]) {
				top[i] = 1; // a가 선두
			}
			else if(a[i] < b[i]) {
				top[i] = 2; // b가 선두
			}
			else {
				top[i] = 3; //공동 선두
			}
		}
		
		int ans = 1;
		for(int i=1; i<totalTime; i++) {
			if(top[i] != top[i+1]) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
    }
}

