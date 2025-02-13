import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[15];
		for(int i=0; i<15;  i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		int total = arr[14];
		int d = total -(a+b+c);
		System.out.print(a+" "+b+" "+c+" "+d);
		
		
		
		sc.close();
    }
}