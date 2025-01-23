import java.util.Scanner;


public class Main {
	
	public static int x,y;
	
	public static int[] dx = new int[] {0,1,0,-1};  // 북 , 동, 남, 서 순서
	public static int[] dy = new int[] {1,0,-1,0};  // 북 , 동, 남, 서 순서
	
	public static int dirNum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.next();
		dirNum = 0;
		x = 0;
		y = 0;
		for(int i=0; i<command.length(); i++) {
			if(command.charAt(i)=='L') {
				dirNum = (dirNum -1 + 4) % 4;
			}
			else if(command.charAt(i)=='R') {
				dirNum = (dirNum +1) % 4;
			}
			else {
				x+=dx[dirNum];
				y+=dy[dirNum];
			}
		}
		System.out.println(x+" "+y);
		
		sc.close();
    }
}
