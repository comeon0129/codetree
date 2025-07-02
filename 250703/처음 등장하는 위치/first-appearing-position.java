import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        
        for(int i=1; i<=n; i++) {
        	int num = sc.nextInt();
        	if(!m.containsKey(num))
        		m.put(num, i);
        }
        Iterator<Entry<Integer,Integer>> it = m.entrySet().iterator();
        
        while(it.hasNext()) {
        	Entry<Integer, Integer> entry = it.next();
        	System.out.println(entry.getKey()+" "+entry.getValue());
        }
        sc.close();
    }
}