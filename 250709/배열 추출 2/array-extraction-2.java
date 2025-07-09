import java.util.PriorityQueue;
import java.util.Scanner;

class Number implements Comparable<Number>{
	int x, org_x;
	
	public Number(int x, int org_x) {
		this.x = x;
		this.org_x = org_x;
	}
	
	@Override
	public int compareTo(Number o) {
		if(this.org_x != o.org_x)
			return this.org_x-o.org_x;
		else
			return this.x - o.x;
	}
}

public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
  
        PriorityQueue<Number> pq = new PriorityQueue<>();
        
        while(n-->0) {
        	int x = sc.nextInt();
        	
        	if(x!=0)
        		pq.add(new Number(x, Math.abs(x)));
        	else {
        		if(pq.isEmpty())
        			System.out.println(0);
        		else
        			System.out.println(pq.poll().x);
        	}
        	
        }
       
        sc.close();
    }
}