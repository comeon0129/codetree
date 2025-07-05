import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        TreeSet<Integer> s = new TreeSet<>();
        
        while(n-->0) {
        	s.add(sc.nextInt());
        }
        
        while(k-->0) {
        	System.out.print(s.last());
        	s.remove(s.last());
        }
        
        sc.close();
    }
}
