import java.util.Scanner;

class Quest{
	int e, t; // e: 경험치 t: 깨는데 걸리는 시간
	public Quest(int e, int t) {
		this.e = e;
		this.t = t;
	}
}

public class Main {
	public static int n; // 퀘스트 개수
	public static int m; // 얻어야 하는 경험치 양
	public static final int MAX_T = 10000;
	public static Quest[] quests; 
	
	public static int[] dp; // dp[i] : 걸린 시간이 i일때 획득할 수 있는 최대 경험치 양
	
	public static void initalize() {
		for(int i=0; i<dp.length; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		dp[0] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		quests = new Quest[n];
		dp = new int[MAX_T+1];
		
		for(int i=0; i<n; i++) {
			int e = sc.nextInt();
			int t = sc.nextInt();
			quests[i] = new Quest(e,t);
		}
		
		initalize();
		
		for(int i=0; i<n; i++) {
			for(int t= MAX_T; t>=0; t--) {
				if(t < quests[i].t || dp [t-quests[i].t]==Integer.MIN_VALUE)
					continue;
				dp[t] = Math.max(dp[t], dp[t-quests[i].t]+quests[i].e);
			}
		}
		int ans = -1;
		
		for(int t=1; t<=MAX_T; t++) {
			if(dp[t] >= m) {
				ans = t;
				break;
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
}
