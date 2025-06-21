import java.util.Scanner;

class Cloth{
	int s, e; //옷을 입기 시작할 수 있는 날짜, 옷을 입을 수 있는 마지막 날짜
	int v; //옷의 화려함
	
	public Cloth(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
}

public class Main {
	public static int n; //n: 옷의 개수
	public static int m; //m: 옷을 입는 일수
	public static Cloth[] clothes; 
	public static int[][] info; // info[i][j]: i번째 일에 j번째 옷을 입었을때의 화려함
	public static int[][] dp; //dp[i][j]: i번째 일까지 옷을 다 입었을때, 마지막 날 입은 옷이 j번째 옷일때 얻을 수 있는 최대만족도
	
	public static void initalize() {
		dp = new int[m+1][n];
		for(int i=1; i<=m; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] =Integer.MIN_VALUE;
			}
		}
		for(int i=0; i<n; i++) {
			dp[1][i] = 0;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		clothes = new Cloth[n];
		
		for(int i=0; i<n; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			clothes[i] = new Cloth(s,e,v);
		}
		
		info = new int[m+1][n];
		
		for(int i=1; i<=m; i++) {
			for(int j=0; j<n; j++) {
				if(i >= clothes[j].s && i<=clothes[j].e)
					info[i][j] = clothes[j].v;
			}
		}
		
		initalize();
		
		for(int i=2; i<=m; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(info[i][j] !=0 && info[i-1][k] != 0)
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+Math.abs(info[i][j]-info[i-1][k]));
				}
			}
		}
		
		int ans = -1;
		
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, dp[m][i]);
		}
		
		System.out.println(ans);
		sc.close();
	}
}