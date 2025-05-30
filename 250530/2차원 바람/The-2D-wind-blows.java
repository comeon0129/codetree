import java.util.Scanner;


public class Main {
	public static int n,m; //n,m: 격자 크기
	public static int[][] building;
	public static int q; // 바람 분 횟수
	public static int r1,c1; //바람에 영향을 받는 직사각형 좌측 상단 좌표
	public static int r2,c2; //바람에 영향을 받는 직사각형 좌측 하단 좌표
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=m;
	}
	
	//직사각형 안에 있는 숫자들의 값을 변경하기 위한 함수
	public static void changeValue(int r1, int c1, int r2, int c2) {
		int[][] temp = new int[n+1][m+1];
		
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				int cnt = 1;
				int sum = building[i][j];
				
				if(inRange(i-1,j)) {
					cnt++;
					sum+=building[i-1][j];
				}
				if(inRange(i,j+1)) {
					cnt++;
					sum+=building[i][j+1];
				}
				if(inRange(i+1,j)) {
					cnt++;
					sum+=building[i+1][j];
				}
				if(inRange(i,j-1)) {
					cnt++;
					sum+=building[i][j-1];
				}
				temp[i][j] = sum / cnt;
			}
		}
		
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				building[i][j] = temp[i][j];
			}
		}
		
		return;
	}
	
	//바깥쪽 직사각형 경계에 있는 숫자들을 시계방향으로 회전시키기 위한 함수
	public static void outsideRotate(int r1, int c1, int r2, int c2) {
		int temp1 = building[r1][c2];
		int temp2= building[r2][c2];
		int temp3 = building[r2][c1];

		//가로 맨 윗줄 이동
		for(int i=c2; i>=c1+1; i--) {
			building[r1][i] = building[r1][i-1];
		}
		//세로 맨 오른쪽줄 이동
		for(int i=r2; i>=r1+1; i--) {
			building[i][c2] = building[i-1][c2];
		}
		//가로 맨 아랫줄 이동
		for(int i =c1; i<c2; i++) {
			building[r2][i] = building[r2][i+1];
		}
		//세로 맨 왼쪽줄 이동
		for(int i=r1; i<r2; i++) {
			building[i][c1] = building[i+1][c1];
		}
		building[r1+1][c2] = temp1;
		building[r2][c2-1] = temp2;
		building[r2-1][c1] = temp3;

		return;
	}
	
	//직사각형 범위에 대해 바람이 불어 변화를 주는 함수
	public static void wind(int r1, int c1, int r2, int c2) {
		outsideRotate(r1,c1,r2,c2);
		changeValue(r1,c1,r2,c2);
	}

	//건물의 상태를 출력하기 위한 함수
	public static void printBuilding() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(building[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		building = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				building[i][j] = sc.nextInt();
			}
		}
		
		while(q-->0) {
			r1 = sc.nextInt();
			c1 = sc.nextInt();
			r2 = sc.nextInt();
			c2 = sc.nextInt();
			wind(r1,c1,r2,c2);
		}
		
		printBuilding();
		
		sc.close();
	}
}
