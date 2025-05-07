import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int n;
	
	public static int r,c;
	
	public static int ans = 0;
	
	public static int[][] num = new int[4][4];
	
	public static int[][] numDir = new int[4][4];
	
	
	public static ArrayList<Integer> combination = new ArrayList<>();
	
	public static int[] dx = {-1,-1,0,1,1,1,0,-1};
	
	public static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	
	public static void calc() {
		ans = Math.max(ans, combination.size());
	}
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static void findMax(int x, int y) {
		calc();
		
		if(!inRange(x,y)) {
			return;
		}
		
		if((combination.size() !=0 && num[x][y] <= combination.get(combination.size()-1)) || combination.contains(num[x][y])){
			return;
		}
		
		int moveX = dx[numDir[x][y]-1];
		int moveY = dy[numDir[x][y]-1];
		
		for(int i=0; i<n; i++) {
			combination.add(num[x][y]);
			findMax(x+moveX*i,y+moveY*i);
			combination.remove(combination.size()-1);
		}
			
	}
	
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		num[i][j]= sc.nextInt();
        	}
        }
        
        
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		numDir[i][j]= sc.nextInt();
        	}
        }
        
        r= sc.nextInt();
        c = sc.nextInt();

        findMax(r-1,c-1);
        
        System.out.println(ans-1);
        sc.close();
    }
}