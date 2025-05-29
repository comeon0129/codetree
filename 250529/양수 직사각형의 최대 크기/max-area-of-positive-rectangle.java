import java.util.Scanner;

public class Main {
	public static int n,m;
	public static int[][] grid;
	
	public static int maxSize = -1;
	
	
	//한 직사각형의 양 꼭짓점이 (x1,y1),(x2,y2)일때 직사각형 안에 값이 전부 양수인지를 판단하는 함수
	public static boolean isAllPositive(int x1, int y1, int x2, int y2){
		for(int i=x1; i<=x2; i++) {
			for(int j= y1; j<=y2; j++) {
				if(grid[i][j]<=0)
					return false;
			}
		}
		return true;
	}
	
	// 한 직사각형의 양 꼭짓점이 (x1,y1), (x2,y2)일때 크기를 반환하는 함수
	public static int getSize(int x1, int y1, int x2, int y2) {
		return (x2-x1+1)*(y2-y1+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=i; k<n; k++) {
					for(int l=j; l<m; l++) {
						if(isAllPositive(i,j,k,l)) {
							maxSize = Math.max(maxSize, getSize(i,j,k,l));
						}
					}
				}
			}
		}
		System.out.println(maxSize);
		
		sc.close();
	}
}
