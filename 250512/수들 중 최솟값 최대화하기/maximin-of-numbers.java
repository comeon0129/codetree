import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[][] grid;
	
	public static boolean[] selected;
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static int ans =0;
	
	public static int calcMaxMin() {
		int minVal = Integer.MAX_VALUE;
		
		for(int i=0; i<answer.size(); i++) {
			minVal = Math.min(minVal, grid[i][answer.get(i)]);
		}
		
		return minVal;
		
	}
	
	
	public static void choose(int curNum) {
		if(curNum == n) {
			ans = Math.max(ans, calcMaxMin());
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(selected[i])
				continue;
			
			selected[i] = true;
			answer.add(i);
			choose(curNum+1);
			
			answer.remove(answer.size()-1);
			selected[i] = false;
			
		}
		
		
		
	}
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        grid = new int[n][n];
        
        selected = new boolean[n];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		grid[i][j] = sc.nextInt();
        	}
        }
        
        choose(0);
       
        System.out.println(ans);
        
        sc.close();
    }
}