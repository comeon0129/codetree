import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n;
	
	public static int[] a = new int[MAX_N];
	public static int[] b = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int maxTime = 0;
		for(int i=0; i<n; i++) {
			int[] workTime = new int[1000];
			int time = 0;
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				for(int k=a[j]; k<b[j]; k++) {
					workTime[k]++;
				}
			}
			for(int j=0; j<workTime.length; j++) {
				if(workTime[j] > 0) {
					time++;
				}
			}
			maxTime = Math.max(maxTime, time);
		}
		System.out.println(maxTime);
		
		sc.close();
    }
}