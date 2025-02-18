import java.util.Scanner;

public class Main {
	public static int n,m;
	
	public static int[] numbers = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int maxNum = 0;
		for(int i=0; i<n; i++) {
			maxNum = Math.max(maxNum, numbers[i]);
		}
		int ans = 0;
		for(int i=maxNum; i<=10000; i++) {
			int curSum = 0;
			int doorCnt = 0;
			for(int j=0; j<n; j++) {
				curSum += numbers[j];
				if(curSum <= i)
					continue;
				doorCnt++;
				curSum = numbers[j];
			}
			if(doorCnt == m-1) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		sc.close();
    }
}