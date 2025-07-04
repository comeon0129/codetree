import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        TreeSet<Integer> s = new TreeSet<>();
        
        for(int i=1; i<=m; i++) {
        	s.add(i);
        }
        
        while(n-->0) {
        	int num = sc.nextInt();
        	
        	s.remove(num);
        	
        	System.out.println(s.last());
        	
        }
        
 
        sc.close();
    }
}
