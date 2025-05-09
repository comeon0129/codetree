import java.util.Scanner;


class Pos {
	public int x;
	public int y;
	
	public Pos(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	
}


public class Main {
	
	public static int n,m;
	
	public static boolean[] used = new boolean[20];
	
	public static Pos[] coordinates = new Pos[20];
	
	public static double ans = Integer.MAX_VALUE;
	
	public static double calcDist(int i, int j) {
		return Math.pow(coordinates[i].x-coordinates[j].x, 2) + Math.pow(coordinates[i].y-coordinates[j].y, 2);
	}
	
	public static double calcMaxDist() {
		double maxDist = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(used[i] && used[j]) {
					maxDist = Math.max(maxDist, calcDist(i,j));
				}
			}
		}
		return maxDist;
	}
	
	public static void findMin(int curIdx, int cnt) {
		if(cnt == m) {
			ans = Math.min(ans, calcMaxDist());
			return;
		}
		if(curIdx == n)
			return;
		
		
		// 주어진 점을 선택하지 않는 경우
		findMin(curIdx+1,cnt);
		
		
		//주어진 점을 선택하는 경우
		used[curIdx] = true;
		findMin(curIdx+1,cnt+1);
		used[curIdx] = false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			coordinates[i] = new Pos(x, y);
		}
		
		findMin(0,0);
		System.out.println((int)ans);
		
		sc.close();
	}
}
