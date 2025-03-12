import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static int n,k;
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        n = sc.nextInt();
        k = sc.nextInt();
        
        int num = 1;
        while(n-->0) {
        	q.add(num);
        	num++;
        }
        
        
        
        while(q.size() != 0) {
        	for(int i=0; i<k-1; i++) {
        		q.add(q.poll());
        	}
        	System.out.print(q.poll()+" ");
        }
        sc.close();
    }
}
