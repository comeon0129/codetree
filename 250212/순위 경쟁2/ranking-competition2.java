import java.util.Scanner;

public class Main {
	
	public static final int MAX_N =100;
	public static int n;
	
	public static int[] a_score = new int[MAX_N+1];
	public static int[] b_score = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			char c = sc.next().charAt(0);
			int s = sc.nextInt();
			if(c == 'A') {
				a_score[i] = a_score[i-1]+s;
				b_score[i] = b_score[i-1];
			}
			else {
				b_score[i] = b_score[i-1]+s;
				a_score[i] = a_score[i-1];
			}
		}
		
		
		int cnt =0;
		int leader = 0;
		for(int i=1; i<=n; i++) {
			if(a_score[i] < b_score[i] && leader !=2) {
				leader = 2;
				cnt++;
			}
			else if(a_score[i] == b_score[i] && leader !=3) {
				leader = 3;
				cnt++;
			}
			else if(a_score[i] > b_score[i] && leader != 1) {
				leader = 1;
				cnt++;
			}
		}
		System.out.println(cnt);
		
		sc.close();
    }
}

