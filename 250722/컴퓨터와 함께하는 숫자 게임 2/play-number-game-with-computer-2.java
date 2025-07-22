import java.util.Scanner;

public class Main {
	
	public static int binarySearch(long m, long target) {
		long left = 1;
		long right = m;
		int cnt = 1;
		while(left<=right) {
			long mid = (left+right)/2;
			
			if(mid == target) 
				break;
			
			if(mid > target)
				right = mid-1;
			else
				left = mid+1;
			cnt++;
		}
		
		return cnt;	
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        
        int minCnt = Integer.MAX_VALUE;
        int maxCnt = Integer.MIN_VALUE;
        
        long a = sc.nextInt();
        long b = sc.nextInt();
        
        for(long target = a; target<=b; target++) {
        	int tempCnt = binarySearch(m, target);
        	minCnt = Math.min(minCnt, tempCnt);
        	maxCnt = Math.max(maxCnt, tempCnt);
        }
        System.out.println(minCnt+" "+maxCnt);
        
        
        sc.close();
    }
}
