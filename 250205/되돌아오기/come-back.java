import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int x,y;
	
	public static int[] dx = new int[] {1,-1,0,0};
	public static int[] dy = new int[] {0,0,-1,1};
	
	public static int chooseNum (char dir) {
		if(dir == 'E') {
			return 0;
		}
		else if(dir == 'W') {
			return 1;
		}
		else if(dir == 'S') {
			return 2;
		}
		else {
			return 3;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = 0; 
		y = 0;
		int time = 0;
		int ans = -1;
		for(int i=0; i<n; i++) {
			char dir = sc.next().charAt(0);
			int dist = sc.nextInt();
			int dirNum = chooseNum(dir);
			for(int j=0; j<dist; j++) {
				x = x + dx[dirNum];
				y = y + dy[dirNum];
				time++;
				if(x == 0 && y == 0) {
					ans = time;
				}
			}
		}
		System.out.println(ans);
				
		sc.close();
    }
}
