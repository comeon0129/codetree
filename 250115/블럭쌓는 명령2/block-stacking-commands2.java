import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] section = new int[n];
		for(int i=0; i<k; i++) {
			int a= sc.nextInt();
			int b= sc.nextInt();
			for(int j =a-1; j<=b-1; j++) {
				section[j] ++;
			}
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<section.length; i++) {
			if(section[i] > max) {
				max = section[i];
			}
		}
		System.out.println(max);
		
		
		sc.close();
    }
}
