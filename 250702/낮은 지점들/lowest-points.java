
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Pos implements Comparable<Pos>{
	int x, y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Pos o) {
		return this.y - o.y;
	}
}

public class Main {
	public static int n;
	public static HashMap<Integer, Integer> save = new HashMap<>();
	public static Pos[] pos;
	
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pos = new Pos[n];
        
        for(int i=0; i<n; i++) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	pos[i] = new Pos(x,y);
        }
        
        Arrays.sort(pos);
        
        for(int i=0; i<n; i++) {
        	if(!save.containsKey(pos[i].x))
        		save.put(pos[i].x, pos[i].y);
        }
        
        int sum = 0;
        
        for(Integer i: save.keySet()) {
        	sum+= save.get(i);
        }
        System.out.println(sum);
        
        sc.close();
    }
}
