import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Marble implements Comparable<Marble> {
	int x, y; // 구슬 위치
	int d; //향하는 방향
	int w; //구슬의 무게
	int number; //순서
	
	public Marble(int x, int y, int d, int w, int number) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.w = w;
		this.number = number;
	}
	
	@Override
	public int compareTo(Marble m) {
		return this.number-m.number;
	}
}

public class Main {
	public static int n;//격자 크기
	public static int m; //구슬 개수
	public static int t;//시간
	
	public static ArrayList<Marble> marbles = new ArrayList<>();
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static void mixMarbles(int x, int y) {
		ArrayList<Marble> mix = new ArrayList<>();
		
		for(Marble m : marbles) {
			if(m.x == x && m.y == y)
				mix.add(m);
		}
		
		marbles.removeIf(m-> m.x == x && m.y == y);
		
		Collections.sort(mix);
		
		Marble survivor = mix.get(mix.size()-1); // 이미 정렬을 해놨던 상태
		
		int totalWeight = 0;
		
		for(Marble m : mix) {
			totalWeight+=m.w;
		}
		survivor.w = totalWeight;
		
		marbles.add(survivor);
	}
	
	public static void moveMarbles() {
		int[] dx = {-1,0,0,1}; //상 좌 우 하 순서
		int[] dy = {0,-1,1,0};
		
		int[][] nextCnt = new int[n+1][n+1];
		
		for(int i=0; i<marbles.size(); i++) {
			int x = marbles.get(i).x;
			int y = marbles.get(i).y;
			int d = marbles.get(i).d;
			
			int nx = x+dx[d], ny = y+dy[d];
			
			if(!inRange(nx,ny)) {
				d= 3-d;
				nextCnt[x][y]++;
			}
			else {
				x= nx;
				y= ny;
				nextCnt[nx][ny]++;
			}
			marbles.get(i).x = x;
			marbles.get(i).y = y;
			marbles.get(i).d = d;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(nextCnt[i][j] >=2)
					mixMarbles(i,j);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		int[] dir = new int[128];
		dir['U'] = 0;
		dir['D'] = 3;
		dir['R'] = 2;
		dir['L'] = 1;
		
		for(int i=1; i<=m; i++) {
			
			int r = sc.nextInt();
			int c = sc.nextInt();
			char d = sc.next().charAt(0);
			int w = sc.nextInt();
			
			marbles.add(new Marble(r, c, dir[d], w, i));
		}
		
		while(t-->0) {
			moveMarbles();
		}
		
		Collections.sort(marbles);
		
		System.out.print(marbles.size()+" ");
		
		Collections.sort(marbles, (a,b)-> a.w-b.w );
		System.out.println(marbles.get(marbles.size()-1).w);
		
		sc.close();
	}
}