import java.util.Scanner;


public class Main {
	
	public static final int MAX_N = 1000000;
	
	public static int n,m;
	
	public static int[] a = new int[MAX_N+1];
	public static int[] b = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int a_idx =1;
		int b_idx =1;
		int timeA = 0;
		int timeB = 0;
		int ans= 0;
		
		for(int i=0; i<n; i++) {
			int t = sc.nextInt();
			char d = sc.next().charAt(0);
			for(int j=0; j<t; j++) {
				if(d == 'L') {
					a[a_idx] = a[a_idx-1]-1;
					a_idx++;
					timeA++;
				}
				else if(d == 'R') {
					a[a_idx] = a[a_idx-1]+1;
					a_idx++;
					timeA++;
				}
			}
		}
		for(int i=0; i<m; i++) {
			int t = sc.nextInt();
			char d = sc.next().charAt(0);
			for(int j=0; j<t; j++) {
				if(d == 'L') {
					b[b_idx] = b[b_idx-1]-1;
					b_idx++;
					timeB++;
				}
				else if(d == 'R') {
					b[b_idx] = b[b_idx-1]+1;
					b_idx++;
					timeB++;
				}
			}
		}
		// 작동이 종료된 이후에도 같은 지점에 머무르기 위한 코드
		for(int i=timeA+1; i<a.length; i++) {
			a[i] = a[i-1];
		}
		for(int i=timeB+1; i<b.length; i++) {
			b[i] = b[i-1];
		}
	
		//더 긴 시간 작동하는 로봇의 시간을 확인하기 위한 변수
		int time = (timeA > timeB) ? timeA : timeB;
		
		for(int i=1; i<=time; i++) {
			if(a[i-1]!=b[i-1] && a[i] == b[i]) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
    }
}
