import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<String, Integer> m = new TreeMap<>();
        
        for(int i=1; i<=n; i++) {
        	String s = sc.next();
        	if(!m.containsKey(s))
        		m.put(s, 1);
        	else
        		m.put(s, m.get(s)+1);
        }
        Iterator<Entry<String,Integer>> it = m.entrySet().iterator();
        
        while(it.hasNext()) {
        	Entry<String, Integer> entry = it.next();
        	System.out.println(entry.getKey()+" "+entry.getValue());
        }
        sc.close();
    }
}