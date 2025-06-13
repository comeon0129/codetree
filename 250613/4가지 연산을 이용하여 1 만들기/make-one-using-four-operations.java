import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int val, cnt;
	
	public Node(int val, int cnt) {
		this.val = val;
		this.cnt = cnt;
	}
}

public class Main {
	public static int n;
	
	public static Queue<Node> q = new LinkedList<>();
	
	public static boolean[] visited;
	
	public static boolean inRange(int val) {
		return 1<= val && val <= 2*n-1;
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.val == 1)
				return node.cnt;
			
			if(inRange(node.val-1) && !visited[node.val-1])
				push(node.val-1,node.cnt+1);
			
			if(inRange(node.val+1) && !visited[node.val+1])
				push(node.val+1,node.cnt+1);
			
			if(node.val % 2 == 0 && inRange(node.val/2) && !visited[node.val/2])
				push(node.val/2, node.cnt+1);
			
			if(node.val % 3 == 0 && inRange(node.val/3) && !visited[node.val/3])
				push(node.val/3, node.cnt+1);
		}
		
		return 0;
	}
	
	public static void push(int n, int cnt) {
		visited[n] = true;
		q.add(new Node(n,cnt));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		visited = new boolean[2*n];
		
		push(n,0);
		
		System.out.println(bfs());
		
		sc.close();
	}
}