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
        	
        	if(s.floor(num-m) != null) {
        		diff = Math.min(diff, num-s.floor(num-m));
        	}
        	
        	if(s.ceiling(num+m) != null) {
        		diff = Math.min(diff, s.ceiling(num+m) - num);
        	}
        	
        	
        }
       
        
        if(diff == Integer.MAX_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(diff);
        
        sc.close();
    }
}
