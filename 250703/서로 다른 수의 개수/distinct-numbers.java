import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        HashSet<Integer> s = new HashSet<>();
        while(n-->0) {
        	int num = sc.nextInt();
        	s.add(num);
        }
        
        System.out.println(s.size());
        
        sc.close();
    }
}