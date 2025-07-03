import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static int n,m;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<n; i++) {
        	int num = sc.nextInt();
        	s.add(num);
        }
        for(int i=0; i<m; i++) {
        	int num = sc.nextInt();
        	s.add(num);
        }
        
        System.out.println(2*s.size()-(n+m));
        
        sc.close();
    }
}