import java.util.Scanner;

public class Main {
	public static final int MAX_N = 10000;
	
	public static int n;
	
	public static int[] blocks = new int [MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int total = 0;
		for(int i=0; i<n; i++) {
			blocks[i] = sc.nextInt();
			total+= blocks[i];
		}
		int target = total/n;
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(blocks[i] > target) {
				ans+=Math.abs(target-blocks[i]);
			}
		}
		System.out.println(ans);
		sc.close();
    }
}
