import java.util.Scanner;

public class Main {
	public static int n;//미로 크기
	public static char[][] maze;
	public static int x,y; //시작 위치
	public static boolean[][] visited; //방문한 곳이었는지 체크
	public static int[][] dir;
	
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static int exit() {
		int[] dx = {0,-1,0,1}; // 오른쪽, 위, 왼쪽, 아래 순서 (반시계방향)
		int[] dy = {1,0,-1,0};
		
		int exitTime = 0;
		int dirNum = 0;
		
		int fixTurn = 0;
		
		while(true) {
			visited[x][y] = true; //x,y 좌표를 방문
			dir[x][y] = dirNum;
			
			int nx = x+dx[dirNum]; int ny = y+dy[dirNum]; //바라보는 방향으로 한 칸 이동
			
			if(!inRange(nx,ny)) { //미로 밖이면 탈출
				exitTime++;
				break;
			}
			
			if(visited[nx][ny] && dir[nx][ny] == dirNum) //이미 방문했던 곳에 다시 돌아온 경우 탈출 불가
				return -1;
			
			if(fixTurn == 4) // 제자리에서 한 바퀴 돈 경우 탈출 불가
				return -1;
			
			//바라보고 있는 방향으로 한칸 갔을때 벽이 있는 경우 반시계방향으로 90도 회전
			if(maze[nx][ny] == '#') {
				dirNum = (dirNum+1) % 4;
				fixTurn++;
				continue;
			}
			
			//이동했을때 해당방향 기준으로 오른쪽에 짚을 벽이 있는 경우
			if(maze[nx+dx[(dirNum+3)%4]][ny+dy[(dirNum+3)%4]] == '#') {
				exitTime++;
			}
			
			else {
				x= nx;
				y= ny;
				visited[x][y] = true; //x,y 좌표를 방문
				dir[x][y] = dirNum;
				
				dirNum = (dirNum+3) % 4;
				nx = x+ dx[dirNum];
				ny = y+dy[dirNum];
				exitTime+=2;
			}
			
			x = nx;
			y = ny;
			
			fixTurn = 0;
				
		}
		
		return exitTime;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		maze = new char[n+1][n+1];
		visited = new boolean [n+1][n+1];
		dir = new int[n+1][n+1];
		
		//못쓰는 기본값으로 초기화
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dir[i][j] = -1;
			}
		}
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		for(int i=1; i<=n; i++){
			String line = sc.next();
			for(int j=1; j<=n; j++) {
				maze[i][j] = line.charAt(j-1);
			}
		}
		
		int exitTime = exit();
		
		System.out.println(exitTime);
		
		sc.close();
	}
}