import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> m = new HashMap<>();
        while(n-->0) {
        	String command = sc.next();
        	
        	if(command.equals("add")) {
        		int key = sc.nextInt();
        		int value = sc.nextInt();
        		m.put(key, value);
        	}
        	else if(command.equals("remove")) {
        		int key = sc.nextInt();
        		m.remove(key);
        	}
        	else if(command.equals("find")) {
        		int key = sc.nextInt();
        		if(m.containsKey(key))
        			System.out.println(m.get(key));
        		else
        			System.out.println("None");
        	}
        	
        	
        }
        
        sc.close();
    }
}