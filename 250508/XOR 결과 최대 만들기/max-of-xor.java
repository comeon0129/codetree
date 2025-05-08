import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static int[] arr = new int [20];
	public static int[] visited = new int[20];
	
	public static int ans = 0;
	
	public static void calc() {
		int temp = 0;
		for(int i=0; i<n; i++) {
			if(visited[i] == 1) {
				temp = temp ^ arr[i];
			}
		}
		ans= Math.max(ans, temp);
		
	}
	
	public static void choose(int curNum, int cnt) {
		if(cnt == m) {
			calc();
			return;
		}
		
		if(curNum == n)
			return;
		
		visited[curNum] = 1;
		choose(curNum+1,cnt+1);
		visited[curNum] = 0;
		
		
		choose(curNum+1,cnt);
		
	}
	
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i=0; i<n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        choose(0,0);
        
        System.out.println(ans);
       
        sc.close();
    }
}
