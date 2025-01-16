import java.util.Scanner;

public class Main {
	
	public static int OFFSET = 100;
	public static int[][] rectangle = new int[201][201];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x1 = sc.nextInt();
			x1+=OFFSET;
			int y1 = sc.nextInt();
			y1+=OFFSET;
			int x2 = sc.nextInt();
			x2+=OFFSET;
			int y2 = sc.nextInt();
			y2+=OFFSET;
			for(int j=x1; j<x2; j++) {
				for(int k= y1; k<y2; k++) {
					rectangle[j][k] =1;
				}
			}
		}
		
		int cnt =0;
		for(int i=0; i<201; i++) {
			for(int j=0; j<201; j++) {
				if(rectangle[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
			
		sc.close();
    }
}
