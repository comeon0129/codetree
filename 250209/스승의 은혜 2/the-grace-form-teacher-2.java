import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static int MAX_N = 1000;
	
	public static int n,b;  // n: 학생수 , b: 예산
	
	public static int[] p = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		b = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			p[i] = sc.nextInt();
		}
		
		Arrays.sort(p,0,n);
		
		int maxCnt = 0;
		for(int i=0; i<n; i++) {
			int cnt = 0;
			int curB = b;
			p[i] /=2;
			for(int j=0; j<n; j++) {
				curB -= p[j];
				if(curB < 0) {
					break;
				}
				cnt++;
			}
			maxCnt = Math.max(maxCnt, cnt);
			p[i] *=2;
		}
		
		System.out.println(maxCnt);
		
		
		sc.close();
    }
}