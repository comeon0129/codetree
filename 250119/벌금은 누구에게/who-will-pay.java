import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] count = new int[n+1];
		int[] input = new int[m];
		int ans = -1;
		for(int i=1; i<=n; i++) {
			count[i] = k;
		}
		for(int i=0; i<m; i++) {
			input[i] = sc.nextInt();
		}
		for(int i=0; i<m; i++) {
			count[input[i]]--;
			if(count[input[i]] == 0) {
				ans = input[i];
				break;
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}