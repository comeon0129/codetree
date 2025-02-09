import java.util.Scanner;

public class Main {

	public static int n,a,b,c;
	public static int[] cups = new int[4];
	public static int[] a_cmd = new int[100];
	public static int[] b_cmd = new int[100];
	public static int[] c_cmd = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		for(int i=0; i<n; i++) {
			a_cmd[i] = sc.nextInt();
			b_cmd[i] = sc.nextInt();
			c_cmd[i] = sc.nextInt();
		}
		
		int maxScore = 0;
		int ans = 0;
		for(int i=1; i<=3; i++) {
			cups[i] = 1;
			int score = 0;
			for(int j=0; j<n; j++) {
				int temp = cups[a_cmd[j]];
				cups[a_cmd[j]] = cups[b_cmd[j]];
				cups[b_cmd[j]] = temp;
				if(cups[c_cmd[j]] == 1) {
					score ++;
				}
			}
			if(score > maxScore) {
				ans = i;
				maxScore = score;
			}  // 가장 최고점수일때의 컵 위치 기록
			for(int j=1; j<=3; j++) {
				cups[j] = 0;
			} //cup 배열 다시 초기화
		}
		System.out.println(ans);
		
		sc.close();
    }
}