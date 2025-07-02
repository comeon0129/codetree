import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static HashMap<String, Integer> h = new HashMap<>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
       int ans = 0;
        
        while(n-->0) {
        	String s = sc.next();
        	char[] c = s.toCharArray();
        	Arrays.sort(c);
        	
        	String result = String.valueOf(c);
        	
        	if(!h.containsKey(result))
        		h.put(result, 1);
        	else
        		h.put(result, h.get(result)+1);
        	
        	ans = Math.max(ans, h.get(result));
        }
        
        System.out.println(ans);
        sc.close();
    }
}