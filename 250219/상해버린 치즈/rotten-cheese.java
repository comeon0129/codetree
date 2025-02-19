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


public class Main {
	
	public static int N,M,D,S;
	public static int[] prescribe = new int[51];  //N명을 기준으로 함
	public static int[] badCheese = new int[51];  // M개를 기준으로 함
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
		
		
		for(int i=0; i<S; i++) {
			int p = sc.nextInt();
			int t = sc.nextInt();
			
			for(int j=0; j<D; j++) {
				if(eatCharts[j].personNum == p && eatCharts[j].time < t) {
					badCheese[eatCharts[j].cheeseNum]++;
				}
			}
		}
		
		for(int i=1; i<=M; i++) {
			if(badCheese[i] == S) {
				for(int j=0; j<D; j++) {
					if(eatCharts[j].cheeseNum == i)
						prescribe[eatCharts[j].personNum] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(prescribe[i] == 1)
				cnt++;
		}
		System.out.println(cnt);
		
		sc.close();
    }
}
