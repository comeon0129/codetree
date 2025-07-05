import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        int[] num = new int[n];
        
        int diff = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++)
        	num[i] = sc.nextInt();
        
        for(int i=0; i<n; i++) {
        	for(int j=i+1; j<n; j++) {
        		int temp = Math.abs(num[i] - num[j]);
        		if(temp >=m)
        			diff= Math.min(diff, temp);
        	}
        }
       
        if(diff == Integer.MAX_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(diff);
        
        sc.close();
    }
}

