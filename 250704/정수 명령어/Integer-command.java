import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
       
        
       while(t-->0) {
    	   TreeSet<Integer> s= new TreeSet<>();
    	   int k = sc.nextInt();
    	   
    	   while(k-->0) {
    		   char c = sc.next().charAt(0);
    		   
    		   if(c == 'I') {
    			   int n = sc.nextInt();
    			   s.add(n);
    		   }
    		   else if(c == 'D') {
    			   int n = sc.nextInt();
    			   if(s.isEmpty())
    				   continue;
    			   if(n==1)
    				   s.remove(s.last());
    			   else
    				   s.remove(s.first());	   
    		   }
    	   }
    	   
    	   if(s.isEmpty())
    		   System.out.println("EMPTY");
    	   else
    		   System.out.println(s.last()+" "+s.first());
    	   
       }
        
        
        sc.close();
    }
}
