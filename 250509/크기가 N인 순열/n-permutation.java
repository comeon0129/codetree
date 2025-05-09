import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static boolean[] visited = new boolean[10];
	
	public static void printAnswer() {
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+" ");
		}
		System.out.println();
		
		return;
	}
	
	public static void choose(int curNum) {
		if(curNum == n) {
			printAnswer();
			return;
		}
		
		for(int i=1; i<=n; i++) {
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
		
		choose(0);
		
		sc.close();
	}
}
