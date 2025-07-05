import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        
        while(n-->0) {
        	int num = sc.nextInt();
        	s.add(num);
        }
        while(m-->0) {
        	int num =sc.nextInt();
        	
        	if(s.floor(num) == null) {
        		System.out.println(-1);
        		continue;
        	}
        		
        	else {
        		System.out.println(s.floor(num));
        		s.remove(s.floor(num));
        	}
        	
        	
        }
       
        sc.close();
    }
}
