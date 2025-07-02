import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> m = new HashMap<>();
        String[] arr = new String[n];
        int ans = 0;
        
        for(int i=0; i<n; i++) {
        	arr[i] = sc.next();
        	
        	if(!m.containsKey(arr[i]))
        		m.put(arr[i], 1);
        	else
        		m.put(arr[i], m.get(arr[i])+1);
        	
        	ans = Math.max(ans, m.get(arr[i]));
        }
        System.out.println(ans);
        
        
        sc.close();
    }
}
