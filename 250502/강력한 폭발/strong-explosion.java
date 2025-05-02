import java.util.Scanner;

import java.util.ArrayList;

class Bomb{
	public int number;
	public int r;
	public int c;
	
	public Bomb(int number, int r, int c) {
		this.number = number;
		this.r = r;
		this.c = c;
	}
}



public class Main {
	
	public static int n;
	
	public static boolean inRange(int x, int y) {
		return x>=1 && x<=n && y>=1 && y<=n;
	}
	
	public static void simulate() {
		int[][] cnt = new int[n+1][n+1];
		
		for(int i=0; i<bombs.size(); i++) {
			int num = bombs.get(i).number;
			int r = bombs.get(i).r;
			int c = bombs.get(i).c;
			
			if(num == 1) { // 1번 폭탄 인경우
				for(int j=-2; j<=2; j++) {
					if(inRange(r+j,c)) {
						cnt[r+j][c]++;
					}
				}
			}
			else if(num == 2) { // 2번 폭탄인 경우
				if(inRange(r-1,c)) {
					cnt[r-1][c]++;
				}
				if(inRange(r+1,c)) {
					cnt[r+1][c]++;
				}
				if(inRange(r,c)) {
					cnt[r][c]++;
				}
				if(inRange(r,c-1)) {
					cnt[r][c-1]++;
				}
				if(inRange(r,c+1)) {
					cnt[r][c+1]++;
				}
			}
			else if(num == 3) { //3번 폭탄인 경우
				if(inRange(r-1,c-1)) {
					cnt[r-1][c-1]++;
				}
				if(inRange(r-1,c+1)) {
					cnt[r-1][c+1]++;
				}
				if(inRange(r,c)) {
					cnt[r][c]++;
				}
				if(inRange(r+1,c-1)) {
					cnt[r+1][c-1]++;
				}
				if(inRange(r+1,c+1)) {
					cnt[r+1][c+1]++;
				}
			}
		}
		
		int temp = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(cnt[i][j]>=1) {
					temp++;
				}
			}
		}
		maxCnt = Math.max(temp, maxCnt);
		
		
	}
	
	public static void choose(int curNum) {
		if(curNum == bombs.size()) {
			for(int i=0; i<bombs.size(); i++) {
				bombs.get(i).number = answer.get(i);
			}
			simulate();
			return;
		}
		
		for(int i=1; i<=3; i++) {
			answer.add(i);
			choose(curNum+1);
			answer.remove(answer.size()-1);
		}
	}
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static ArrayList<Bomb> bombs = new ArrayList<>();
	
	public static int maxCnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int[][] grid = new int[n+1][n+1];
		
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(grid[i][j]==1) {
					Bomb b = new Bomb(0, i, j);
					bombs.add(b);
				}
			}
		}
		
		choose(0);
		System.out.println(maxCnt);
		
		sc.close();
	}
}