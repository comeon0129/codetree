import java.util.Scanner;

public class Main {
	public static int n;//격자 크기
	public static int m;//폭탄이 터지게 만들 조건 -> 행 기준으로 봤을때 연속으로 m개 이상 같은 숫자면 터짐
	public static int k;// 터지고 회전할 횟수
	
	public static int[][] grid;
	
	//시계방향으로 90도 회전시키는 함수
	public static void rotateGrid() {
		int[][] temp = new int[n][n];
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				temp[x][y] = grid[n-1-y][x];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = temp[i][j];
			}
		}
		
		return;
	}
	
	//중력을 적용해 다 밑으로 끌어내리는 함수
	public static void gravity() {
		int[][] temp = new int[n][n];
		
		for(int y=0; y<n; y++) {
			int tempIdx = n-1;
			for(int x=n-1; x>=0; x--) {
				if(grid[x][y] != 0) {
					temp[tempIdx][y] = grid[x][y];
					tempIdx--;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = temp[i][j];
			}
		}
		
		return;
	}
	
	//행 기준으로 봐서 m개 이상 같은 숫자가 적힌 폭탄 들을 터트리고 그 터졌는지 여부를 반환하는 함수
	public static boolean bomb() {
	
		boolean isBomb = false;
			
		for(int y=0; y<n; y++) {
			int groupCnt = 1;
			
			for(int x=0; x<n-1; x++) {	
				if(grid[x][y] != 0 && grid[x][y] == grid[x+1][y])
					groupCnt++;
				else {
					if(groupCnt >=m) {
						for(int i= x-groupCnt+1; i<=x; i++)
							grid[i][y] = 0; //다 터트리기
						isBomb = true;
					}
					groupCnt = 1;
				}
			}
			
			//터트리지 못하고 그냥 끝나버리는 경우 마지막에 한번 더 터트리기
			if(groupCnt >=m) {
				for(int i= n-groupCnt; i<n; i++)
					grid[i][y] = 0; //다 터트리기
				isBomb = true;
			}
			
		}
		
		return isBomb;
	}
	
	//격자 안에 남아있는 폭탄의 개수 세는 함수
	public static int countBomb() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		//귀찮아서 n이 1인 경우에만 예외처리
		
		if(n== 1 && m == 1) {
			System.out.println(0);
		}
		else if(n==1 && m>1) {
			System.out.println(1);
		}
		else {
		
			while(k-->0) {
				boolean isPossible =false;
			
				//더 터질 경우가 없는지 확인해서 있으면 계속해서 폭탄 터트리기
				do {
					isPossible = bomb();
					if(isPossible) // 실제로 터진게 존재하는 경우에만 중력 작용
						gravity();
				} while(isPossible);
			
				//격자 시계방향으로 90도 회전시키고 중력 적용
				rotateGrid();
				gravity();
				//더 터질 경우가 없는지 확인해서 있으면 계속해서 폭탄 터트리기
				do {
					isPossible = bomb();
					if(isPossible) // 실제로 터진게 존재하는 경우에만 중력 작용
						gravity();
				} while(isPossible);
			
			}

			System.out.println(countBomb());
		}
		
		sc.close();
	}
}
