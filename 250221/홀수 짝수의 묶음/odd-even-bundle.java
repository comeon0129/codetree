import java.util.Scanner;

public class Main {
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int even = 0;
		int odd =0;
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num % 2 ==0)
				even++;
			else
				odd++;
		}
		int cnt = 0;
		int turn = 2; // 2면 짝수 턴 , 1이면 홀수 턴
		while(n>0) {
			if(turn == 2) {
				if(even > 0) {
					even--;
					cnt++;
					turn = 1;
				}
				else if(even == 0 && odd == 4) {
					odd-=4;
					cnt++;
					turn = 1;
				}
				else if(even == 0) {
					odd-=2;
					cnt++;
					turn = 1;
				}
			}
			else {
				if(odd > 0) {
					odd--;
					cnt++;
					turn = 2;
				}
			}
			n--;
		}
		System.out.println(cnt);
		
		sc.close();
    }
}