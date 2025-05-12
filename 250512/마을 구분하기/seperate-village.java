import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[][] grid;
	
	public static boolean[][] visited;
	
	public static ArrayList<Integer> cntPerson = new ArrayList<>();
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x<n && 0<=y && y<n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == true || grid[x][y] == 0)
			return false;
		return true;
	}
	
	public static void dfs (int x, int y) {
		int[] dx = {1,0,-1,0}; //아래, 오른쪽, 위, 왼쪽 순서
		int[] dy = {0,1,0,-1}; 
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(canGo(newX,newY)) {
				visited[newX][newY] = true;
				int temp = cntPerson.get(cntPerson.size()-1);
				temp++;
				cntPerson.set(cntPerson.size()-1, temp);
				dfs(newX,newY);
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		grid = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					cntPerson.add(1);
					visited[i][j] = true;
					dfs(i,j);
				}
					
			}
		}
		
		System.out.println(cntPerson.size());
		Collections.sort(cntPerson);
		for(int i=0; i<cntPerson.size(); i++) {
			System.out.println(cntPerson.get(i));
		}
		
		sc.close();
	}
}