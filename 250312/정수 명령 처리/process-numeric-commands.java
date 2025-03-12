import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static int n;
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
       Stack<Integer> s = new Stack<>();
       n = sc.nextInt();
       
       while(n-->0) {
    	   String command = sc.next();
    	   if(command.equals("push")) {
    		   int num = sc.nextInt();
    		   s.push(num);
    	   }
    	   else if(command.equals("pop")) {
    		   System.out.println(s.pop());
    	   }
    	   else if(command.equals("size")) {
    		   System.out.println(s.size());
    	   }
    	   else if(command.equals("empty")) {
    		   if(s.isEmpty())
    			   System.out.println(1);
    		   else
    			   System.out.println(0);
    	   }
    	   else if(command.equals("top")) {
    		   System.out.println(s.peek());
    	   }
       }
       
        sc.close();
    }
}