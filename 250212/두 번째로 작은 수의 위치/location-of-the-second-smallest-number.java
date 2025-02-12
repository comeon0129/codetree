import java.util.Scanner;

public class Main {
	
	public static final int MAX_N =100;
	public static int n;
	
	public static int[] arr =new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//Step 1. 첫번쨰로 작은 값을 찾아내기
		int first = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			first = Math.min(first, arr[i]);
		}
		

		int secondIdx = -1;
		for(int i=first+1; i<=100; i++) {
			boolean isFound = false;
			for(int j=1; j<=n; j++) {
				if(arr[j] == i) {
					if(isFound) {
						secondIdx = -1;
						break;
					}
						
					secondIdx = j;
					isFound = true;
				}
			}
			if(isFound)
				break;
		}
		
		System.out.println(secondIdx);
		
		sc.close();
    }
}