import java.util.Scanner;

public class Main {
	public static int n;
	
	
	public static int ans = 0;
	
	public static int[][] num = new int[4][4];
	
	public static int[][] numDir = new int[4][4];
	
	public static int[] dx = {-1,-1,0,1,1,1,0,-1};
	
	public static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static boolean canGo(int x, int y, int prevNum) {
		return inRange(x,y) && num[x][y] >prevNum;
	}
	
	public static void findMax(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		
		int d = numDir[x][y]-1;
		
		for(int i=0; i<n; i++) {
			int nx = x+dx[d]*i;
			int ny = y+dy[d]*i;
			
			if(canGo(nx,ny,num[x][y])) {
				findMax(nx,ny,cnt+1);
			}
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
        
        int r= sc.nextInt();
        int c = sc.nextInt();

        findMax(r-1,c-1,0);
        
        System.out.println(ans);
        sc.close();
    }
}