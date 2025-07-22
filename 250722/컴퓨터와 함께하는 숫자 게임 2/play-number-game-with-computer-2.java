import java.util.Scanner;

public class Main {
	
	public static int binarySearch(int[] arr, int target) {
		int left = 1;
		int right = arr.length-1;
		int cnt = 1;
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(arr[mid] == target) 
				break;
			
			if(arr[mid] > target)
				right = mid-1;
			else
				left = mid+1;
			cnt++;
		}
		
		return cnt;	
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        
        int[] arr =new int[m+1];
        
        for(int i=1; i<=m; i++)
        	arr[i] = i;
        
        int minCnt = Integer.MAX_VALUE;
        int maxCnt = Integer.MIN_VALUE;
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int target = a; target<=b; target++) {
        	int tempCnt = binarySearch(arr, target);
        	minCnt = Math.min(minCnt, tempCnt);
        	maxCnt = Math.max(maxCnt, tempCnt);
        }
        System.out.println(minCnt+" "+maxCnt);
        
        
        sc.close();
    }
}