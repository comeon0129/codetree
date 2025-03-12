import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
       Stack<Character> s = new Stack<>();
       String word = sc.next();
       for(int i=0; i<word.length(); i++) {
    	   if(word.charAt(i)=='(') {
    		   if(s.size() == word.length()) {
    			   System.out.println("No");
    			   System.exit(0);
    		   }
    		   s.add('(');
    	   }
    	   else {
    		   if(s.isEmpty()) {
    			   System.out.println("No");
    			   System.exit(0);
    		   }
    		   s.pop();
    	   }
       }
       if(!s.isEmpty())
    	   System.out.println("No");
       else
    	   System.out.println("Yes");
       
        sc.close();
    }
}
