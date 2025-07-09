import java.util.PriorityQueue;
import java.util.Scanner;

class Pos implements Comparable<Pos>{
	int x, y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Pos o) {
		if(this.x+this.y > o.x+o.y)
			return 1;
		else if(this.x+this.y == o.x+o.y) {
			if(this.x > o.x)
				return 1;
			else if(this.x == o.x)
				return this.y - o.y;
			else
				return -1;
		}
		else
			return -1;
	}
}

public class Main {
	public static int n,m;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
  
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        
        while(n-->0) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	pq.add(new Pos(x,y));
        }
        
        while(m-->0) {
        	pq.add(new Pos(pq.peek().x+2,pq.peek().y+2));
        	pq.poll();
        	
        }
        
        System.out.println(pq.peek().x+" "+pq.peek().y);
        
        sc.close();
    }
}