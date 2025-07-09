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
        	
        	if(x!=0)
        		pq.add(x);
        	else {
        		if(pq.isEmpty())
        			System.out.println(0);
        		else
        			System.out.println(pq.poll());
        	}
        		
        		
        }
       
        
        sc.close();
    }
}