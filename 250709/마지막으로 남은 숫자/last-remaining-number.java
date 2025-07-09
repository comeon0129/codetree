import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
  
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(n-->0) {
        	int num = sc.nextInt();
        	pq.add(-num);
        }
        
        while(pq.size() >= 2) {
        	int x1 = -pq.poll();
        	int x2 = -pq.poll();
        	
        	if(x1 != x2)
        		pq.add(-Math.abs(x1-x2));
        	
        }
        
        if(pq.isEmpty())
        	System.out.println(-1);
        else
        	System.out.println(-pq.poll());
       
        sc.close();
    }
}