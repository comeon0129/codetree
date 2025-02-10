import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
	public static final int MAX_N = 1000;
	
	public static int n,b;  // n: 학생 수 , b: 예산
	
	public static int[] p = new int[MAX_N];  //선물의 가격
	public static int[] s = new int[MAX_N];  //배송비
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		b = sc.nextInt();
		for(int i=0; i<n; i++) {
			p[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		int maxCnt =0;
		for(int i=0; i<n; i++) {
			int[] temp = new int[MAX_N];
			temp[i] = p[i] / 2 + s[i];
			for(int j=0; j<n; j++) {
				if(i == j)
					continue;
				temp[j] = p[j] + s[j];
			}
			Arrays.sort(temp,0,n);
			int buget = b;
			int cnt = 0;
			for(int j=0; j<n; j++) {
				buget -= temp[j];
				if(buget < 0)
					break;
				cnt++;
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
		sc.close();
    }
}
