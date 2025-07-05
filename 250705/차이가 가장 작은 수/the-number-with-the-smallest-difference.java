import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        
        int diff = Integer.MAX_VALUE;
        
        while(n-->0) {
        	int num = sc.nextInt();
        	s.add(num);
        	
        	if(s.lower(num) != null) {
        		
        		if(num - s.lower(num) >= m)
        			diff = Math.min(diff, num-s.lower(num));
        	}
        	
        	if(s.higher(num) != null) {
        		
        		if(s.higher(num) - num >= m)
        			diff = Math.min(diff, s.higher(num) - num);
        	}
        
        }
       
        if(diff == Integer.MAX_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(diff);
        
        sc.close();
    }
}