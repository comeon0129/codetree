import java.util.Scanner;


public class Main {
	public static int n,m;
	public static int[] arr = new int[100];
	public static int[] beauty = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int ans = 0;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<m; i++) {
			beauty[i] = sc.nextInt();
		}
		
		for(int i=0; i<=n-m; i++) {
			int cnt =0;
			for(int j=i; j<i+m; j++) {
				for(int k=0; k<m; k++) {
					if(beauty[k] == arr[j]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt == m) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
    }
}
