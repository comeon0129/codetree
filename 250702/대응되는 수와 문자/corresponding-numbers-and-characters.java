import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, String> sMap = new HashMap<>();
        HashMap<String, String> iMap = new HashMap<>();
        String[] arr = new String[n];
      
        
        for(int i=0; i<n; i++) {
        	arr[i] = sc.next();
        	
        	sMap.put(arr[i],Integer.toString(i+1));
        	iMap.put(Integer.toString(i+1), arr[i]);
        }
        
        while(m-->0) {
        	String input = sc.next();
        	
        	if(sMap.containsKey(input))
        		System.out.println(sMap.get(input));
        	else
        		System.out.println(iMap.get(input));
        	
        	
        }
        
        sc.close();
    }
}