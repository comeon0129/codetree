import java.util.ArrayList;
import java.util.Scanner;

class Person {
	int s, e, p;
	
	public Person(int s, int e, int p) {
		this.s = s;
		this.e = e;
		this.p = p;
	}
}

public class Main {
	public static int n; //알바생 수
	
	public static ArrayList<Person> people = new ArrayList<>();
	
	public static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int [n]; // dp[i]: i번째 인덱스까지 고려했을때 얻을 수 있는 최대 금액
		
		for(int i=0; i<n; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int p = sc.nextInt();
			people.add(new Person(s, e, p));
		}
		

		for(int i=0; i<n; i++) {
			
			dp[i] = people.get(i).p; //다들 최소 금액이 자기혼자 알바할때 버는 금액은 된다.
			
			for(int j=0; j<i; j++) {
				int startI = people.get(i).s;
				int endJ = people.get(j).e;
				
				if(endJ < startI)
					dp[i] = Math.max(dp[i], dp[j] +dp[i]);
				
			}
		}
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
		
		sc.close();
	}
}
