import java.util.Scanner;

public class Main {
	public static int n,m; //행렬 크기
	public static int q; // 바람부는 횟수
	public static int r; // r: 바람이 불어올 행의 번호
	public static char d; // d: 바람이 불어오는 방향
	
	public static int[][] matrix;
	
	public static boolean[] isWind; //바람이 이미 불었던 행 인지 확인하기 위한 변수
	
	//행의 번호가 r일때, 왼쪽에서 바람이 불어와 오른쪽으로 밀리는 함수
	public static void leftWind(int r) {
		int temp = matrix[r][m];
		for(int i=m; i>=2; i--) {
			matrix[r][i] = matrix[r][i-1];
		}
		matrix[r][1] = temp;
	}
	
	//행의 번호가 r일때, 오른쪽에서 바람이 불어와 왼쪽으로 밀리는 함수
	public static void rightWind(int r) {
		int temp = matrix[r][1];
		for(int i=1; i<=m-1; i++) {
			matrix[r][i] = matrix[r][i+1];
		}
		matrix[r][m] = temp;
	}
	
	//바람이 불어올 행의 번호, 바람이 불어오는 방향(r,d)가 주어졌을때 실제 바람을 일으켜
	//건물을 변형시키는 함수
	public static void wind(int r, char d) {
		if(r== 0 || r>n)
			return;
		
		isWind[r] = true;
		
		if(d=='L') {
			leftWind(r);
			if(isPossible(r-1, r)&& !isWind[r-1])
				wind(r-1,'R');
			if(isPossible(r+1, r) && !isWind[r+1])
				wind(r+1,'R');
		}
		else if(d=='R') {
			rightWind(r);
			if(isPossible(r-1, r) && !isWind[r-1])
				wind(r-1,'L');
			if(isPossible(r+1, r) && !isWind[r+1])
				wind(r+1,'L');
		}
	}
	
	//전파가 가능한지 여부를 판별하는 함수
	public static boolean isPossible(int check, int origin) {
		if(check == 0 || check >n)
			return false;
		
		for(int i=1; i<=m; i++) {
			if(matrix[check][i] == matrix[origin][i])
				return true;
		}
		return false;
	}
	
	
	//행렬을 출력하는 함수
	public static void printMatrix() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		return;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		
		isWind = new boolean[n+2];
		
		matrix = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		while(q-->0) {
			r = sc.nextInt();
			d = sc.next().charAt(0);
			
			wind(r,d);
		}
		
		printMatrix();
		
		sc.close();
	}
}