import java.util.Scanner;


public class Main {
	
	public static int binarySearch(int[] arr, int target) {
		int left = 1;
		int right = arr.length;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(arr[mid] == target)
				return mid;
			
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
        int [] arr = new int[n+1];
        for(int i=1; i<=n; i++)
        	arr[i] = sc.nextInt();
        
        while(m-->0) {
        	int target = sc.nextInt();
        	
        	System.out.println(binarySearch(arr,target));
        }
      
        
        sc.close();
    }
}
