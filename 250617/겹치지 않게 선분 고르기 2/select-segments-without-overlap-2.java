import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Segment implements Comparable<Segment>{
	int x1, x2;
	
	public Segment(int x1, int x2) {
		this.x1 = x1;
		this.x2 = x2;
	}
	
	@Override
	public int compareTo(Segment o) {
		return this.x2- o.x2;
	}
}

public class Main {
	public static int n; //선분의 개수
	
	public static ArrayList<Segment> s = new ArrayList<>();
	
	public static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int [n]; // dp[i]: i번째 인덱스까지 고려했을때 겹치지 않게 가장 많은 수의 선분을 고르는 경우의 수
		
		for(int i=0; i<n; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			s.add(new Segment(x1, x2));
		}
		
		Collections.sort(s); //긴놈이 먼저 자리를 먹어버려서 짧은놈이 등장하지 못하는걸 막기 위함.
		
		int max = s.get(0).x2;
		dp[0] = 1;
		
		for(int i=1; i<n; i++) {
			if(s.get(i).x1 <=max) {
				dp[i] = dp[i-1];
			}
			else {
				dp[i] = dp[i-1]+1;
				max = s.get(i).x2;
			}
		}
		
		System.out.println(dp[n-1]);	
			
		sc.close();
	}
}