import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Coin implements Comparable<Coin> {
	int x,y ;; //코인의 좌표
	int value;
	
	public Coin(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	@Override
	public int compareTo(Coin o) {
		return this.value - o.value;
	}
}

public class Main {
	public static int n;//격자 크기
	
	public static int startX;
	public static int startY;
	public static int endX;
	public static int endY;
	
	public static int coinCnt;
	
	public static int ans = Integer.MAX_VALUE;
	
	public static ArrayList<Coin> coins = new ArrayList<>();
	
	public static boolean[] visited;
	
	public static int calcMinDist() {
		int dist = 0;
		
		ArrayList<Coin> choosenCoins = new ArrayList<>();
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i])
				choosenCoins.add(coins.get(i));
		}
		
		Collections.sort(choosenCoins);
		
		dist += Math.abs(startX - choosenCoins.get(0).x); //x만큼 이동
		dist += Math.abs(startY - choosenCoins.get(0).y); //y만큼 이동
		
		dist += Math.abs(choosenCoins.get(0).x - choosenCoins.get(1).x); //x만큼 이동
		dist += Math.abs(choosenCoins.get(0).y - choosenCoins.get(1).y); //y만큼 이동
		
		dist += Math.abs(choosenCoins.get(1).x - choosenCoins.get(2).x); //x만큼 이동
		dist += Math.abs(choosenCoins.get(1).y - choosenCoins.get(2).y); //y만큼 이동
		
		dist += Math.abs(choosenCoins.get(2).x - endX); //x만큼 이동
		dist += Math.abs(choosenCoins.get(2).y - endY); //y만큼 이동
		
		return dist;
	}
	
	//지금까지 선택한 동전의 개수가 cnt개라 했을 때, curNum 번째 위치에 있는 동전을 선택할지 말지 정하는 함수
	public static void chooseCoin(int curNum, int cnt) {
		if(cnt == 3) {
			ans = Math.min(ans, calcMinDist());
			return;
		}
		
		if(curNum == coinCnt)
			return;
		
		//동전을 선택하지 않는 경우
		chooseCoin(curNum+1, cnt);
		
		//동전을 선택하는 경우
		visited[curNum] = true;
		chooseCoin(curNum+1, cnt+1);
		visited[curNum] = false;
		
	}
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String line = sc.next();
			
			for(int j=0; j<line.length(); j++) {
				if(line.charAt(j) == 'S') {
					startX = i;
					startY = j;
				}
				else if(line.charAt(j) =='E') {
					endX = i;
					endY = j;
				}
				else if(line.charAt(j) == '.') {
					continue;
				}
				else {
					coins.add(new Coin(i, j, line.charAt(j)-'0'));
				}
			}
		}
		
		coinCnt = coins.size();
		visited = new boolean[coinCnt];
		
		chooseCoin(0,0);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
		
		sc.close();
	}
		
}
