import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Marble implements Comparable<Marble>{
	double x, y;
	int w;
	int d;
	int number;
	
	public Marble(double x, double y, int w, int d, int number) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.d = d;
		this.number = number;
	}
	
	@Override
	public int compareTo(Marble o) {
		if(this.w > o.w)
			return 1;
		else if(this.w == o.w)
			return this.number - o.number;
		else
			return -1;
	}
}

public class Main {
	public static int t; //총 테스트 수
	public static int n; //구슬의 개수
	public static ArrayList<Marble> marbles;
	public static int time = 0;
	public static int ans = -1;
	
	public static double[] dx = {0.0,0.0,0.5,-0.5}; //UDRL 순서
	public static double[] dy = {0.5,-0.5,0.0,0.0};
	
	public static void simulate() {
		HashMap<String, ArrayList<Marble>> posMap = new HashMap<>(); 
		
		for(Marble m : marbles) {
			m.x+=dx[m.d];
			m.y+=dy[m.d];
			
			//부동 소수점 오차에 의해 키값이 달라지는걸 방지하기 위함
			int scaledX = (int)(m.x * 2);
			int scaledY = (int)(m.y * 2);
			
			String key = scaledX+" "+scaledY;
			posMap.putIfAbsent(key, new ArrayList<>());
			posMap.get(key).add(m);
		}
		
		ArrayList<Marble> newMarbles = new ArrayList<>();
		
		boolean isCollision = false;
		
		for(ArrayList<Marble> m : posMap.values()) {
			if(m.size() == 1) //충돌이 없는 경우
				newMarbles.add(m.get(0));
			else {
				isCollision = true;
				Collections.sort(m);
				newMarbles.add(m.get(m.size()-1));
			}
		}
		
		if(isCollision)
			ans = time;
		
		marbles = newMarbles;
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			time = 0;
			ans = -1;
			marbles = new ArrayList<>();
			
			for(int i=1; i<=n; i++) {
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				int w = sc.nextInt();
				char d = sc.next().charAt(0);
				
				int dirNum = -1;
				
				if(d == 'U')
					dirNum = 0;
				else if(d == 'D')
					dirNum = 1;
				else if(d == 'R')
					dirNum = 2;
				else
					dirNum =3;
				
				marbles.add(new Marble(x,y,w,dirNum,i));
			}
			
			while(time++ < 4000)
				simulate();
			
			System.out.println(ans);
		}
		
		sc.close();
	}
}

