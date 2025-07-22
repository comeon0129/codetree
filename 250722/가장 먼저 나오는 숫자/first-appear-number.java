import java.util.Scanner;


public class Main {
	
	public static int lowerBound(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
		int minIdx = arr.length;
			
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(arr[mid] >= target) {
				right = mid-1;
				minIdx= Math.min(minIdx, mid);
			}
			else
				left = mid+1;
		}
		
		return minIdx;	
	}
	
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
			
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(arr[mid] == target) {
				return mid;
			}
			
			if(arr[mid] < target)
				left = mid+1;
			else
				right = mid-1;
		}
		
		return -1;	
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextInt();
        
        while(m-->0) {
        	int target = sc.nextInt();
        	
        	if(binarySearch(arr, target) == -1)
        		System.out.println(-1);
        	else
        		System.out.println(lowerBound(arr, target)+1);
        	
        }
      
        
        sc.close();
    }
}
