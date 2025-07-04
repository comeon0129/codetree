import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s= new TreeSet<>();
        
        while(n-->0) {
        	String command =  sc.next();
        	
        	if(command.equals("add")) {
        		int x = sc.nextInt();
        		s.add(x);
        	}
        	else if(command.equals("remove")) {
        		int x = sc.nextInt();
        		s.remove(x);
        	}
        	else if(command.equals("find")) {
        		int x = sc.nextInt();
        		if(s.contains(x))
        			System.out.println(true);
        		else
        			System.out.println(false);
        	}
        	else if(command.equals("lower_bound")) {
        		int x = sc.nextInt();
        		if(s.ceiling(x) == null)
        			System.out.println("None");
        		else
        			System.out.println(s.ceiling(x));
        	}
        	else if(command.equals("upper_bound")) {
        		int x = sc.nextInt();
        		if(s.higher(x) == null)
        			System.out.println("None");
        		else
        			System.out.println(s.higher(x));
        	}
        	else if(command.equals("largest")) {
        		if(s.isEmpty())
        			System.out.println("None");
        		else
        			System.out.println(s.last());
        	}
        	else if(command.equals("smallest")) {
        		if(s.isEmpty())
        			System.out.println("None");
        		else
        			System.out.println(s.first());
        	}
        }
        
        
        sc.close();
    }
}
