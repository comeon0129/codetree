import java.util.Scanner;

public class Main {
	
	public static final int MAX_R = 200;
	public static final int OFFSET = 100;
	
	
	public static int[][] checked = new int[MAX_R+1][MAX_R+1];
	public static int N ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int x= sc.nextInt();
			int y= sc.nextInt();	
			x+=OFFSET;
			y+=OFFSET;
			for(int j=x; j<x+8; j++) {
				for(int k=y; k<y+8; k++) {
					checked[j][k] = 1;
				}
			}
		}
		
		
		
		int area =0;
		for(int i=0; i<=MAX_R; i++) {
			for(int j=0; j<=MAX_R; j++) {
				if(checked[i][j] == 1) {
					area++;
				}
			}
		}
		System.out.println(area);
				
		sc.close();
    }
}