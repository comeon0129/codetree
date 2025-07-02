import java.util.HashMap;
import java.util.Scanner;
public class Main {
	public static int n,k;
	public static long[] arr;

	public static HashMap<Long, Integer> m = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new long[n];
        int cnt = 0;
        
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextLong();
        
        for(int i=2; i<n; i++) {
        	m = new HashMap<>();
        	long c = arr[i]; 
        	
        	for(int j=0; j<i; j++) {
        		
        		if(m.containsKey(k-c-arr[j]))
        			cnt+=m.get(k-c-arr[j]);
        		
        		if(m.containsKey(arr[j]))
        			m.put(arr[j], m.get(arr[j])+1);
        		else
        			m.put(arr[j], 1);
        	}
        	
        }
        System.out.println(cnt);
        
        sc.close();
    }
}