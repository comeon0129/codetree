import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
  
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(n-->0) {
        	int x = sc.nextInt();
        	
        	pq.add(x);
        	
        	if(pq.size()<3)
        		System.out.println(-1);
        	else {
        		int x1 = pq.poll();
        		int x2 = pq.poll();
        		int x3 = pq.poll();
        		System.out.println(x1*x2*x3);
        		pq.add(x1);
        		pq.add(x2);
        		pq.add(x3);
        	}
        		
        	
        }
       
        sc.close();
    }
}