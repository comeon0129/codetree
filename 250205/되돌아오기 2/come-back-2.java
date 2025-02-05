import java.util.Scanner;

public class Main {
	
	public static int x,y;
	
	public static int elapsedTime;
	
	public static int[] dx = new int[] {1,0,-1,0};  //동,남,서,북 순서
	public static int[] dy = new int[] {0,-1,0,1};

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.next();
		int dirNum = 0;
		x=0;
		y=0;
		elapsedTime = 0;
		int ans = -1;
		for(int i=0; i<command.length(); i++) {
			if(command.charAt(i) == 'L') {
				dirNum = (dirNum-1+4) % 4;
				elapsedTime++;
			}
			else if(command.charAt(i) == 'R') {
				dirNum = (dirNum+1) % 4 ;
				elapsedTime++;
			}
			else {
				x = x + dx[dirNum];
				y = y + dy[dirNum];
				elapsedTime++;
			}
			if(x==0 && y == 0) {
				ans = elapsedTime;
				break;
			}
		}
		System.out.println(ans);
				
		sc.close();
    }
}