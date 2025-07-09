import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(n-->0) {
        	String command = sc.next();
        	
        	if(command.equals("push")) {
        		int a = sc.nextInt();
        		pq.add(-a);
        	}
        	else if(command.equals("pop")) {
        		System.out.println(-pq.poll());
        	}
        	else if(command.equals("size")) {
        		System.out.println(pq.size());
        	}
        	else if(command.equals("empty")) {
        		if(pq.isEmpty())
        			System.out.println(1);
        		else
        			System.out.println(0);
        	}
        	else
        		System.out.println(-pq.peek());
        	
        }
        
        
        sc.close();
    }
}