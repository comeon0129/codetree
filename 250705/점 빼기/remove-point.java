import java.util.Scanner;
import java.util.TreeSet;

class Pos implements Comparable<Pos>{
	int x, y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Pos o) {
		if(this.x > o.x) return 1;
		else if(this.x == o.x) return this.y - o.y;
		else return -1;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        TreeSet<Pos> s = new TreeSet<>();
        
        while(n-->0) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	s.add(new Pos(x,y));
        }
        
        while(m-->0) {
        	int k = sc.nextInt();
        	
        	if(s.ceiling(new Pos(k,0)) == null)
        		System.out.println("-1 -1");
        	else {
        		System.out.println(s.ceiling(new Pos(k,0)).x+" "+s.ceiling(new Pos(k,0)).y);
        		s.remove(s.ceiling(new Pos(k,0)));
        	}
        		
        	
        }
       
        sc.close();
    }
}