
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
		
		for(int i=0; i<n; i++) {
			if(cost[i][answer.get(i)]== 0)
				return;
			
			sum += cost[i][answer.get(i)];
		}
		
		ans = Math.min(ans, sum);
		
		return;
	}
	
	public static void findMin(int curNum) {
		if(curNum == n) {
			calcMinSum();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;
			
			if(answer.size()>0) {
				int lastNum = answer.get(answer.size()-1);
				if(lastNum != i-1 && lastNum !=i+1 && lastNum !=i+n-1 && lastNum !=i-(n-1))
					continue;
			}
						
			visited[i] = true;
			answer.add(i);
			
			findMin(curNum+1);
			
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
		
		findMin(0);
		
		System.out.println(ans);
		
		sc.close();
	}
}

