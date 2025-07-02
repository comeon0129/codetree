import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Integer> h = new HashMap<>();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i]= sc.nextInt();
        	
        	if(h.containsKey(arr[i]))
        		h.replace(arr[i], h.get(arr[i])+1);
        	else
        		h.put(arr[i], 1);
        }
        while(m-->0) {
        	int key = sc.nextInt();
        	if(h.containsKey(key))
        		System.out.print(h.get(key)+" ");
        	else
        		System.out.print(0+" ");
        }
        
        
        sc.close();
    }
}