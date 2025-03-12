import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
	public static int n;
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        n = sc.nextInt();
        for(int i=1; i<=n; i++) {
        	dq.add(i);
        }
        while(dq.size()!=1) {
        	dq.pop();
        	dq.add(dq.poll());
        }
        System.out.println(dq.peek());
        
        sc.close();
    }
}