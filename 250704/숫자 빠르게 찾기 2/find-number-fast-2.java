import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        TreeSet<Integer> s = new TreeSet<>();
        
        for(int i=0; i<n; i++)
        	s.add(sc.nextInt());
        
       while(m-->0) {
    	   int num = sc.nextInt();
    	   
    	   if(s.ceiling(num) == null)
    		   System.out.println(-1);
    	   else
    		   System.out.println(s.ceiling(num));
    	   
       }
 
        sc.close();
    }
}