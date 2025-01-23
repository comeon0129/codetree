import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int n = sc.nextInt();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i=0; i<n; i++) {
			char pos = sc.next().charAt(0);
			int dist = sc.nextInt();
			if(pos == 'E') {
				x += dist*dx[0];
				y += dist*dy[0];
			}
			else if(pos == 'W') {
				x += dist*dx[1];
				y += dist*dy[1];
			}
			else if(pos == 'S') {
				x += dist*dx[2];
				y += dist*dy[2];
			}
			else if(pos == 'N') {
				x += dist*dx[3];
				y += dist*dy[3];
			}
		}
		System.out.println(x+" "+y);
		
		
		sc.close();
    }
}
