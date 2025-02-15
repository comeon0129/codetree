import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int n;
	
	public static int[] x = new int[MAX_N];
	public static int[] y = new int[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<=100; i+=2) {
			for(int j=0; j<=100; j+=2) {
				int[] sector = new int[4];
				for(int k=0; k<n; k++) {
					if(x[k] > i && y[k] > j) {
						sector[0]++;
					}
					else if(x[k] < i && y[k] > j) {
						sector[1]++;
					}
					else if(x[k] < i && y[k] < j) {
						sector[2]++;
					}
					else {
						sector[3]++;
					}
				}
				int maxCnt =0;
				for(int k=0; k<4; k++) {
					maxCnt = Math.max(maxCnt, sector[k]);
				}
				ans = Math.min(ans, maxCnt);
				
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}