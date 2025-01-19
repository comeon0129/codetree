import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] count = new int[n+1];
		int ans = -1;
		for(int i=1; i<=n; i++) {
			count[i] = k;
		}
		for(int i=0; i<m; i++) {
			int num = sc.nextInt();
			count[num]--;
			if(count[num] == 0) {
				ans = num;
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}