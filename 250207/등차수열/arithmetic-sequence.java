import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int[] arr = new int[100];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i=1; i<=100; i++) {  // 자연수 k의 범위
			int cnt = 0;
			for(int j=0; j<n; j++) {
				int minus1 = Math.abs(arr[j]-i);
				for(int k=j+1; k<n; k++) {
					int minus2 = Math.abs(arr[k]-i);
					if(minus1 == minus2) {
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
		
		sc.close();
    }
}