import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static int n; //격자 크기
	public static int m; //움직이는 횟수
	
	public static ArrayList<Integer>[][] grid;
	
	public static int x, y, idx;
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static void findXY(int num) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=0; k<grid[i][j].size(); k++) {
					if(grid[i][j].get(k) == num) {
						x= i;
						y = j;
						idx = k;
						return;
					}
				}
				
			}
		}
	}
	
	public static void move(int num) {
		findXY(num);
		
		int[] dx = {0,-1,-1,-1,0,1,1,1};
		int[] dy = {1,1,0,-1,-1,-1,0,1};
		
		int maxX = -1;
		int maxY = -1;
		int maxNum = Integer.MIN_VALUE;
		
		for(int d=0; d<8; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(inRange(nx,ny) && !grid[nx][ny].isEmpty()) {
				for(int k=0; k<grid[nx][ny].size(); k++) {
					if(grid[nx][ny].get(k) > maxNum) {
						maxX= nx;
						maxY = ny;
						maxNum = grid[nx][ny].get(k);
					}
				}
			}
		}
		
		if(maxX == -1) { //이동할 곳이 없는 경우
			return;
		}
		
		ArrayList<Integer> moving = new ArrayList<>(grid[x][y].subList(0, idx + 1));
		
		grid[x][y] = new ArrayList<>(grid[x][y].subList(idx + 1, grid[x][y].size()));
		
		for(int i=0; i<grid[maxX][maxY].size(); i++) {
			moving.add(grid[maxX][maxY].get(i));
		}
		
		grid[maxX][maxY] = new ArrayList<>(moving);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new ArrayList[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = new ArrayList<>();
				grid[i][j].add(sc.nextInt());
			}
		}
		
		while(m-->0) {
			int moveNum = sc.nextInt();
			move(moveNum);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(grid[i][j].isEmpty()) {
					System.out.println("None");
				}
				else {
					for(int k=0; k<grid[i][j].size(); k++) {
							System.out.print(grid[i][j].get(k)+" ");
					}
					System.out.println();
				}
			}
		}
		
		
		sc.close();
	}
}

