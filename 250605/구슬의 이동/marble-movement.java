import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Marble implements Comparable<Marble>{
	int x,y; //초기 위치
	int d; //방향
	int v; //속도
	int number;
	
	public Marble(int x, int y, int d, int v, int number) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.v = v;
		this.number = number;
	}
	@Override
	public int compareTo(Marble m) {
		if(this.v > m.v)
			return 1;
		else if(this.v == m.v) {
			return this.number-m.number;
		}
		else
			return -1;
	}
	
}

public class Main {
	public static int n; //격자 크기
	public static int m; //구슬 개수
	public static int t; //시간
	public static int k; //살아남을 수 있는 최대 구슬 수

	public static ArrayList<Marble> marbles = new ArrayList<>();
	
	public static void removeMarble(int x, int y, int cnt) {
		for(int i=0; i<marbles.size(); i++) {
			if(marbles.get(i).x == x && marbles.get(i).y == y) {
				marbles.remove(i);
				i--;
				cnt--;
				
				if(cnt<=k)
					break;	
			}
		}
	}
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static void move() {
		int[][] nextCnt = new int[n+1][n+1];
		
		int[] dx = {-1,0,0,1}; //위 왼쪽 오른쪽 아래
		int[] dy = {0,-1,1,0};
		
		for(int i=0; i<marbles.size(); i++) {
			int x = marbles.get(i).x;
			int y = marbles.get(i).y;
			int d = marbles.get(i).d;
			int v = marbles.get(i).v;
			
			while(v-->0) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(!inRange(nx,ny)) {
					d = Math.abs(d-3);
					v++;
				}
				else {
					x= nx;
					y= ny;
				}
			}
			
			nextCnt[x][y]++;
			/*바뀐 값들 정보 업데이트 해주기 */
			marbles.get(i).x = x;
			marbles.get(i).y = y;
			marbles.get(i).d = d;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(nextCnt[i][j] > k) {
					removeMarble(i,j,nextCnt[i][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		k = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			char d = sc.next().charAt(0);
			int v = sc.nextInt();
			
			int dirNum = -1;
			
			if(d == 'U')
				dirNum = 0;
			else if(d=='D')
				dirNum = 3;
			else if(d == 'R')
				dirNum = 2;
			else
				dirNum = 1;
			
			marbles.add(new Marble(r, c, dirNum, v,i+1));
		}
		Collections.sort(marbles);
		
		while(t-->0) {
			move();
		}
		
		System.out.println(marbles.size());
		
		sc.close();
	}
}
