import java.util.ArrayList;
import java.util.Collections;
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
		else if(this.w == o.w) {
			return this.number-o.number;
		}
		else
			return -1;
	}
}

public class Main {
	public static int t; //테스트 수
	public static int n; //구슬 개수
	public static int time =0;
	public static int ans = -1;
	public static ArrayList<Marble> marbles;
	
	public static double[] dx = {-0.5,0.5,0.0,0.0}; //UDRL 순서
	public static double[] dy = {0.0,0.0,0.5,-0.5};
	
	public static void simulate() {
		
		for(Marble m : marbles) {
			m.x+= dx[m.d];
			m.y+= dy[m.d];
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t-->0) {
			n = sc.nextInt();
			marbles = new ArrayList<>();
			time = 0;
			ans = -1;
			
			for(int i=1; i<=n; i++) {
				double x = sc.nextInt();
				double y = sc.nextInt();
				int w = sc.nextInt();
				char d = sc.next().charAt(0);
				int dirNum = -1;
				if(d== 'U')
					dirNum = 0;
				else if(d == 'D')
					dirNum = 1;
				else if(d == 'R')
					dirNum = 2;
				else 
					dirNum = 3;
				
				marbles.add(new Marble(x,y,w,dirNum,i));
			}
			Collections.sort(marbles);
			
			while(time < 4000) {
				time++;
				simulate();
			}
			
			System.out.println(ans);
		}
		
		sc.close();
	}
}