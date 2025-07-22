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
	
	public static int upperBound(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
		int minIdx = arr.length;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(arr[mid] > target) {
				right = mid-1;
				minIdx= Math.min(minIdx, mid);
			}
			else
				left = mid+1;
		}
		
		return minIdx;	
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
        	
        	System.out.println(upperBound(arr,target)-lowerBound(arr,target));
        }
      
        
        sc.close();
    }
}
