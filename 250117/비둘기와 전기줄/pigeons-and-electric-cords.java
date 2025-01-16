import java.util.Scanner;

public class Main {
	
	public static int n;
	public static final int MAX_N = 10;
	public static int[] pCount = new int[MAX_N+1];
	public static int[] arr = new int[MAX_N+1];
	
	public static boolean test(int p_num, int pos) {
		if(pCount[p_num] >= 2) {
			if(arr[p_num] != pos) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int p_num = sc.nextInt();
			int pos = sc.nextInt();
			pCount[p_num] ++;
			if(test(p_num,pos)) {
				cnt++;
			}
			arr[p_num] = pos;
		}
		System.out.println(cnt);
		
		sc.close();
    }
}
