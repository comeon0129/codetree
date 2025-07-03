
import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static int n,m;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        HashSet<Integer> s = new HashSet<>();
        while(n-->0) {
        	int num = sc.nextInt();
        	s.add(num);
        }
        
        m = sc.nextInt();
        while(m-->0) {
        	int num = sc.nextInt();
        	
        	if(s.contains(num)) {
        		System.out.println(1);
        	}
        	else
        		System.out.println(0);
        }
        
        sc.close();
    }
}