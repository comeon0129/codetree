import java.util.Scanner;


public class Main {
	
	public static int n;
	public static int[] room = new int[1003];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			room[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<n; j++) {
				sum+=room[(i+j)%n]*j;
			}
			min = Math.min(min, sum);
		}
		System.out.println(min);
		
		sc.close();
    }
}
