import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static boolean[] visited = new boolean[10];
	
	public static int[][] board = new int [10][10];
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static int ans = 0;
	
	public static void calcMaxSum() {
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += board[i][answer.get(i)];
		}
		
		ans = Math.max(ans, sum);
		
		return;
	}
	
	public static void choose(int curNum) {
		if(curNum == n) {
			calcMaxSum();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			answer.add(i);
			
			choose(curNum+1);
			
			answer.remove(answer.size()-1);
			visited[i] = false;
			
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] =sc.nextInt();
			}
		}
		
		choose(0);
		
		System.out.println(ans);
		
		sc.close();
	}
}
