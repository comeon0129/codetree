import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        
        while(n-->0) {
        	String command = sc.next();
        	
        	if(command.equals("add")) {
        		int k = sc.nextInt();
        		int v = sc.nextInt();
        		m.put(k, v);
        	}
        	else if(command.equals("remove")) {
        		int k = sc.nextInt();
        		m.remove(k);
        	}
        	else if(command.equals("find")) {
        		int k = sc.nextInt();
        		if(m.containsKey(k))
        			System.out.println(m.get(k));
        		else
        			System.out.println("None");
        	}
        	else if(command.equals("print_list")) {
        		Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
        		if(m.isEmpty())
        			System.out.println("None");
        		else {
        			while(it.hasNext()) {
        				Entry<Integer, Integer> entry = it.next();
        				System.out.print(entry.getValue()+" ");
        			}
        			System.out.println();
        		}
        		
        	}
        	
        }
       
        sc.close();
    }
}
