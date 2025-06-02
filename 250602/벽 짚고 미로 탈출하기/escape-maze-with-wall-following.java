import java.util.Scanner;

public class Main {
	public static int n;//미로 크기
	public static char[][] maze;
	public static int x,y; //시작 위치
	public static boolean[][][] visited; //방문한 곳이었는지 체크
	
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static int exit() {
		int[] dx = {0,-1,0,1}; // 오른쪽, 위, 왼쪽, 아래 순서 (반시계방향)
		int[] dy = {1,0,-1,0};
		
		int time = 0;
		int dirNum = 0;
		
	
		while(true) {
			
			if(visited[x][y][dirNum]) //이미방문한 적이 있는 장소+방향 인경우 탈출
				return -1;
			
			visited[x][y][dirNum] = true; //x,y 좌표를 방문
			
			int nx = x+dx[dirNum]; int ny = y+dy[dirNum]; //바라보는 방향으로 한 칸 이동
			
			if(!inRange(nx,ny)) { //미로 밖으로 벗어난 경우
				time++;
				break;
			}
			
			//바라보고 있는 방향으로 한칸 갔을때 벽이 있는 경우 반시계방향으로 90도 회전
			if(maze[nx][ny] == '#') {
				dirNum = (dirNum+1) % 4;
				continue;
			}
			
			//이동했을때 해당방향 기준으로 오른쪽에 짚을 벽이 없는 경우
			if(maze[nx+dx[(dirNum+3)%4]][ny+dy[(dirNum+3)%4]] != '#') {
				x = nx;
				y = ny;
				time++;
				visited[x][y][dirNum] = true; //x,y 좌표를 방문
				dirNum = (dirNum+3) % 4;
				nx = x+ dx[dirNum];
				ny = y+dy[dirNum];
			}
			
			x = nx;
			y = ny;
			time++;
				
		}
		
		return time;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		maze = new char[n+1][n+1];
		visited = new boolean [n+1][n+1][4];
		
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