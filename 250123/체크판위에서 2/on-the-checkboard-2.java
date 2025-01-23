import java.util.Scanner;


public class Main {
	
	public static int r,c;
	public static int ans;
	
	public static char[][] rect =new char[16][16];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				rect[i][j] = sc.next().charAt(0);
			}
		}
		char start = rect[1][1];
		char end = rect[r][c];
		
		if (start == end) {
			System.out.println(0);
		}
		else {
			for(int i=2; i<=r-2; i++) {
				for(int j =2; j<=c-2; j++) {
					if(start != rect[i][j]) {
						for(int k=i+1; k<=r-1; k++) {
							for(int l=j+1; l<=c-1; l++) {
								if(rect[i][j] != rect[k][l]) {
									ans++;
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(ans);
		
		sc.close();
    }
}
