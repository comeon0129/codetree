import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static boolean[] visited = new boolean[10];
	
	public static int[][] cost = new int [10][10];
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static int ans = Integer.MAX_VALUE;
	
	
	public static void calcMinSum() {
		int sum = 0;
		
		for(int i=0; i<answer.size()-1; i++) {
			if(cost[answer.get(i)][answer.get(i+1)] == 0)
				return;
			sum += cost[answer.get(i)][answer.get(i+1)];
		}
		
		int lastX = answer.get(answer.size()-1); 
		if(cost[lastX][0] == 0)
			return;
		else {
			sum+=cost[lastX][0];
		}

		ans = Math.min(ans, sum);
		
		return;
	}
	
	public static void findMin(int cnt) {
		
		if(cnt == n) {
			calcMinSum();
			return;
		}
		
	
		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			answer.add(i);
			
			findMin(cnt+1);
			
			answer.remove(answer.size()-1);
			visited[i] = false;
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
		
		visited[0] = true;
		answer.add(0);
		findMin(1);
		
		System.out.println(ans);
		
		sc.close();
	}
}
