import java.util.Scanner;

public class Main {
	
	public static int n,m; // n: vertex의 개수 m: 간선의 개수
	
	public static int[][] graph;
	
	public static boolean[] visited;
	
	public static int ans = 0;
	
	public static void dfs(int vertex) {
		for(int i=1; i<=n; i++) {
			if(graph[vertex][i] == 1 && !visited[i]) {
				ans++;
				visited[i] = true;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		while(m-->0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		
		visited[1] = true;
		dfs(1);
		
		System.out.println(ans);
		sc.close();
	}
}
