import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static int n;
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        n = sc.nextInt();
        while(n-->0) {
        	String command = sc.next();
        	if(command.equals("push")) {
        		int a = sc.nextInt();
        		q.add(a);
        	}
        	else if(command.equals("pop")) {
        		System.out.println(q.poll());
        	}
        	else if(command.equals("size")) {
        		System.out.println(q.size());
        	}
        	else if(command.equals("empty")) {
        		if(q.isEmpty())
        			System.out.println(1);
        		else
        			System.out.println(0);
        	}
        	else if(command.equals("front")) {
        		System.out.println(q.peek());
        	}
        }
        
        sc.close();
    }
}