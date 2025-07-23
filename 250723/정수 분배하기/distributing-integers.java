import java.util.Scanner;

public class Main {
	
	public static int[] arr;
	public static int n,m;
	
	
	public static boolean isPossible(int k) {
		int totalCnt = 0;
		for(int i=0; i<n; i++) {
			int tempCnt = arr[i] / k;
			totalCnt+=tempCnt;
		}
		return totalCnt >=m;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //처음 정수의 개수
        m = sc.nextInt(); // 총 만들 정수의 개수
        arr = new int[n];
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextInt();
        
        int left = 1;
        int right = 100000;
        int maxK = 0;
        
        while(left<=right) {
        	int mid = (left+right) /2;
        	if(isPossible(mid)) {
        		left = mid+1;
        		maxK = Math.max(maxK, mid);
        	}
        	else
        		right = mid-1;
        }
        
        System.out.println(maxK);
        
        sc.close();
    }
}
