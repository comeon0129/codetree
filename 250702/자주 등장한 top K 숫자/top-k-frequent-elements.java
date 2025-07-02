import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Count implements Comparable<Count>{
	int key, value;
	
	public Count(int key, int value) {
		this.key =key;
		this.value = value;
	}
	
	@Override
	public int compareTo(Count o) {
		if(this.value > o.value)
			return -1;
		else if(this.value == o.value)
			return o.key - this.key;
		else
			return 1;
	}
}

public class Main {
	
	public static int n;
	public static int k;
	public static HashMap<Integer, Integer> h = new HashMap<>();
	
	public static ArrayList<Count> sortedMap = new ArrayList<>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        while(n-->0) {
        	int num = sc.nextInt();
        	
        	if(!h.containsKey(num))
        		h.put(num, 1);
        	else
        		h.put(num, h.get(num)+1);
        }
        
        for(Integer i : h.keySet())
        	sortedMap.add(new Count(i,h.get(i)));
        
        Collections.sort(sortedMap);
        
        for(int i=0; i<k; i++)
        	System.out.print(sortedMap.get(i).key+" ");
        
        sc.close();
    }
}