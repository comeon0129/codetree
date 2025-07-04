import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
      
        TreeSet<Integer> s = new TreeSet<>();
        
        int minDist = Integer.MAX_VALUE;
        
        s.add(0);
       
        while(n-->0) {
        	int x =sc.nextInt();
        	s.add(x);
        	
        	if(s.higher(x) != null) {
        		minDist = Math.min(minDist, s.higher(x) - x);
        	}
        	
        	minDist = Math.min(minDist, x-s.lower(x));
        	
        	System.out.println(minDist);
        }
        
        
        
        sc.close();
    }
}