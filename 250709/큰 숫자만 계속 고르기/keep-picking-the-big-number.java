import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
	public static int n,m;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(n-->0) {
        	int num = sc.nextInt();
        	pq.add(-num);
        }
        
        while(m-->0) {
        	pq.add(pq.poll()+1);
        }
        
        System.out.println(-pq.peek());
        
        sc.close();
    }
}