import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        HashSet<Integer> s = new HashSet<>();
        while(n-->0) {
        	String command = sc.next();
        	
        	if(command.equals("add")) {
        		int x = sc.nextInt();
        		s.add(x);
        	}
        	else if(command.equals("remove")) {
        		int x = sc.nextInt();
        		s.remove(x);
        	}
        	else {
        		int x = sc.nextInt();
        		if(s.contains(x))
        			System.out.println(true);
        		else
        			System.out.println(false);
        	}
        }
       
        sc.close();
    }
}