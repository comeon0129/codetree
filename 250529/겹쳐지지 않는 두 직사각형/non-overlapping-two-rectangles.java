import java.util.Scanner;

public class Main {
	public static int n,m;
	public static int[][] grid;
	
	public static int maxSum =Integer.MIN_VALUE;
	
	public static int[][] visited;
	
	
	//두 직사각형의 양 꼭짓점 (x1,y1),(x2,y2),(i,j),(k,l)을 기준으로 두 직사각형을
	//그려봤을때 겹쳐지는 지점이 있는지 확인하는 함수
	public static boolean overlapped(int x1, int y1, int x2, int y2, int i, int j, int k, int l) {
		visited = new int[n][m];
		
		for(int a=x1; a<=x2; a++) {
			for(int b=y1; b<=y2; b++) {
				visited[a][b] ++;
			}
		}
		
		for(int a=i; a<=k; a++) {
			for(int b=j; b<=l; b++) {
				visited[a][b] ++;
			}
		}
		
		for(int a=0; a<n; a++) {
			for(int b=0; b<m; b++) {
				if(visited[a][b] >=2)
					return true;
			}
		}
		return false;
	}
	
	
	//직사각형이 (x1,y1),(x2,y2)를 양꼭짓점으로 할때, 그 직사각형 안에 숫자 합을 반환하는 함수
	public static int rectSum(int x1, int y1, int x2, int y2) {
		int sum = 0;
		for(int i = x1; i<=x2; i++) {
			for(int j=y1; j<=y2; j++) {
				sum+=grid[i][j];
			}
		}
		return sum;
	}
	
	
	//첫번째 직사각형 (x1,y1,x2,y2)를 양꼭짓점으로 할때,
	//두번 째 직사각형을 겹치지 않게 잡아 최대 합을 반환하는 함수
	public static int findMaxSum(int x1, int y1, int x2, int y2) {
		int sum = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=i; k<n; k++) {
					for(int l=j; l<m; l++) {
						if(!overlapped(x1,y1,x2,y2,i,j,k,l)) {
							sum = Math.max(sum, rectSum(x1,y1,x2,y2)+rectSum(i,j,k,l));
						}
					}
				}
			}
		}
		return sum;
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
					for(int l= j; l<m; l++) {
						maxSum = Math.max(maxSum, findMaxSum(i,j,k,l));
					}
				}
			}
		}
		
		System.out.println(maxSum);
		
		sc.close();
	}
}
