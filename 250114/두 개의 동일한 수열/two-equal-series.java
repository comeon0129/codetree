import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean flag = true;
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			if(arr1[i] != arr2[i]) {
				flag = false;
			}
		}
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		sc.close();
    }
}