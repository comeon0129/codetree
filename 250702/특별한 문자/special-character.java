import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static HashMap<Character, Integer> h = new HashMap<>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        for(int i=0; i<s.length(); i++) {
        	if(!h.containsKey(s.charAt(i)))
        		h.put(s.charAt(i), 1);
        	else
        		h.put(s.charAt(i), h.get(s.charAt(i))+1);
        }
        
        boolean flag = false;
        
        for(int i=0; i<s.length(); i++) {
        	if(h.get(s.charAt(i)) == 1) {
        		System.out.print(s.charAt(i));
        		flag = true;
        		break;
        	}
        }
        
        if(!flag)
        	System.out.println("None");
        
        sc.close();
    }
}