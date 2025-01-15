import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] line = new int[201];
		for(int i=0; i<n; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			int offset = 100;
			for(int j = x1+offset; j<=x2-1+offset; j++) {
				line[j] ++;
			}
		}
		int max =0;
		for(int i=0; i<line.length; i++) {
			if(line[i] > max) {
				max = line[i];
			}
		}
		
		System.out.println(max);
		
		
		sc.close();
    }
}
