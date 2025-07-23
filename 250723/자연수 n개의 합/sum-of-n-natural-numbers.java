import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        
        long left = 1;
        long right = Integer.MAX_VALUE;
        long maxN = Integer.MIN_VALUE;
        
        while(left<=right) {
        	long mid = (left+right)/2;
        	if(mid *(mid+1) / 2 <= s) {
        		left = mid+1;
        		maxN = Math.max(maxN, mid);
        	}
        	else
        		right = mid-1;
        }
        
        System.out.println(maxN);
        
        sc.close();
    }
}