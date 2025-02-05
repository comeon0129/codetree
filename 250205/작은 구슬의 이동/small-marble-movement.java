import java.util.Scanner;


public class Main {
	
	public static int n, t, r, c;
	
	public static char d;
	
	public static int[][] board = new int[51][51];
	
	
	public static boolean inRange (int x, int y) {
		return (1 <= x && x <= n && 1 <= y && y <=n); 
	}

	// x는 행이고 y는 열이라고 생각할것.
	public static int[] dx = new int[] {0,1,-1,0};  //순서가 오른쪽, 아래, 위, 왼쪽
	public static int[] dy = new int[] {1,0,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.next().charAt(0);
		
		int dirNum = 0;
		
		if(d == 'R') {
			dirNum = 0;
		}
		else if(d == 'D') {
			dirNum = 1;
		}
		else if(d == 'U') {
			dirNum = 2;
		}
		else if(d == 'L') {
			dirNum = 3;
		}
		
		for(int i=1; i<=t; i++){
			int nx = r+ dx[dirNum];
			int ny = c+ dy[dirNum];
			if(!inRange(nx,ny)) {
				dirNum = 3- dirNum;
				i++;
			}
			r= r+dx[dirNum];
			c= c+dy[dirNum];
		}
		System.out.println(r+" "+c);
		
		
		sc.close();
    }
}