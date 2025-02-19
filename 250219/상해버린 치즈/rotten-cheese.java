import java.util.Arrays;
import java.util.Scanner;

class Chart{
	int personNum;
	int cheeseNum;
	int time;
	
	public Chart(int personNum, int cheeseNum, int time) {
		this.personNum = personNum;
		this.cheeseNum = cheeseNum;
		this.time = time;
	}
}

class SickChart{
	int personNum;
	int time;
	
	public SickChart(int personNum, int time) {
		this.personNum = personNum;
		this.time = time;
	}
}


public class Main {
	
	public static int N,M,D,S;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 사람 수
		M = sc.nextInt(); // 치즈 수
		D = sc.nextInt(); // 치즈 먹은 기록 수
		S = sc.nextInt(); // 아픈 기록 수
		
		Chart[] eatCharts = new Chart[D];
		
		for(int i=0; i<D; i++) {
			int p = sc.nextInt();
			int m = sc.nextInt();
			int t = sc.nextInt();
			eatCharts[i] = new Chart(p, m, t);
		}
		
		Arrays.sort(eatCharts,(a,b) -> a.time - b.time);
		
		SickChart[] sickCharts = new SickChart[S];
		
		for(int i=0; i<S; i++) {
			int p = sc.nextInt();
			int t = sc.nextInt();
			sickCharts[i] = new SickChart(p,t);
		}
		
		int maxCnt = 0;
		for(int i=1; i<=M; i++) {
			boolean isPossible = true;
			int[] sickTime = new int[N+1];
			int[] isUsed = new int[N+1];
			for(int j=0; j<D; j++) {
				if(eatCharts[j].cheeseNum == i && isUsed[eatCharts[j].personNum] == 0) {
					sickTime[eatCharts[j].personNum] = eatCharts[j].time+1;
					isUsed[eatCharts[j].personNum] = 1;
				}
			}
			
			for(int j=0; j<S; j++) {
				if(sickTime[sickCharts[j].personNum] == 0 || sickTime[sickCharts[j].personNum] > sickCharts[j].time) {
					isPossible = false;
					break;
				}
			}
			int cnt = 0;
			if(isPossible) {
				for(int j=1; j<=N; j++) {
					if(sickTime[j] > 0)
						cnt++;
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		
		System.out.println(maxCnt);
		sc.close();
    }
}