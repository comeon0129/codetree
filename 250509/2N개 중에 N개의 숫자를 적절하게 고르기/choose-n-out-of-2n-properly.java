import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static boolean[] used = new boolean[20];
	
	public static int[] arr = new int[20];
	
	public static int ans = Integer.MAX_VALUE;
	
	public static int calc() {
		int chooseSum=0;
		int notChooseSum =0;
		
		for(int i=0; i<2*n; i++) {
			if(used[i])
				chooseSum+=arr[i];
			else
				notChooseSum+=arr[i];
		}
		
		return Math.abs(chooseSum-notChooseSum);
		
	}
	
	public static void findMin(int currIdx, int cnt) {
		if(cnt == n) {
			ans = Math.min(ans, calc());
			return;
		}
		
		if(currIdx == 2*n)
			return;
		
		//case 1. 지금 숫자를 선택하지 않는 경우
		
		findMin(currIdx+1, cnt);
		
		// case 2. 지금 숫자를 선택 하는 경우
		used[currIdx] = true;
		findMin(currIdx+1,cnt+1);
		used[currIdx] = false;
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<2*n; i++) {
			arr[i] = sc.nextInt();
		}
		
		findMin(0,0);
		
		System.out.println(ans);
		
		sc.close();
	}
}
