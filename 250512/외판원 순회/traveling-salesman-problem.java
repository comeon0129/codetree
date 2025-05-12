import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static boolean[] visited = new boolean[10];
	
	public static int[][] cost = new int [10][10];
	
	public static ArrayList<Integer> y_pos = new ArrayList<>();
	public static ArrayList<Integer> x_pos = new ArrayList<>();
	
	public static int ans = Integer.MAX_VALUE;
	
	
	public static void calcMinSum(int curX) {
		int sum = 0;
		
		for(int i=0; i<n-1; i++) {
			sum += cost[x_pos.get(i)][y_pos.get(i)];
		}
		
		if(cost[curX][0] == 0)
			return;
		else {
			sum+=cost[curX][0];
		}

		ans = Math.min(ans, sum);
		
		return;
	}
	
	public static void findMin(int cnt, int curX) {
		
		if(cnt == n-1) {
			calcMinSum(curX);
			return;
		}
		
	
		for(int i=0; i<n; i++) {
			if(visited[i] || cost[curX][i] == 0)
				continue;
				
			visited[curX] = true;
				
			x_pos.add(curX);
			y_pos.add(i);
				
			findMin(cnt+1,i);
				
			x_pos.remove(x_pos.size()-1);
			y_pos.remove(y_pos.size()-1);
			visited[curX] = false;
				
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cost[i][j] =sc.nextInt();
			}
		}
		
		
		findMin(0,0);
		
		System.out.println(ans);
		
		sc.close();
	}
}