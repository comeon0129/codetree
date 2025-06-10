import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Marble {
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
			if(m.size() == 1) {
				newMarbles.add(m.get(0));
			} else {
				isCollision = true;
				Marble max = m.get(0);
				for (int i = 1; i < m.size(); i++) {
					if (m.get(i).w > max.w || 
					    (m.get(i).w == max.w && m.get(i).number > max.number)) {
						max = m.get(i);
					}
				}
				newMarbles.add(max);
			}
		}
		
		if(isCollision)
			ans = time;
		
		marbles = newMarbles;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			time = 0;
			ans = -1;
			marbles = new ArrayList<>();
			
			for(int i=1; i<=n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				String d = st.nextToken();
				
				int dirNum = -1;
				
				if(d.equals("U"))
					dirNum = 0;
				else if(d.equals("D"))
					dirNum = 1;
				else if(d.equals("R"))
					dirNum = 2;
				else
					dirNum =3;
				
				marbles.add(new Marble(x,y,w,dirNum,i));
			}
			
			int stableCount = 0;
			int prevSize = n;
			while (time++ < 4000) {
			    simulate();
			    if (marbles.size() <= 1) break;

			    if (marbles.size() == prevSize) {
			        stableCount++;
			        if (stableCount >= 5) break;
			    } else {
			        stableCount = 0;
			    }
			    prevSize = marbles.size();
			}
			
			bw.write(ans+" ");
			bw.write('\n');
			
		}
		bw.flush();
		bw.close();
	}
}
