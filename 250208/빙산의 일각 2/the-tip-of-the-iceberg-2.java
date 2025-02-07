import java.util.Scanner;

public class Main {

	public static int n ;
	public static int[] arr = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int maxCnt = 0;
		for(int i=1; i<=1000; i++) {
			int cnt = 0;
			for(int j=0; j<n-1; j++) {   // 모든 케이스가 다되고 마지막 혼자 솟아있는 경우가 적용이 안됨 그래서 따로 예외처리
				int curHeight = arr[j] - i;
				int nextHeight = arr[j+1]- i;
				if(curHeight >0 && nextHeight <= 0 ) {
					cnt++;
				}
			}
			if(arr[n-1]-i >0) {
				cnt++;
			}
			System.out.println(cnt);
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
		
		sc.close();
    }
}
