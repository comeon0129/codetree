import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] arr = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<7; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int total = arr[6];
		for(int i=0; i<7; i++) {
			for(int j=i+1; j<7; j++) {
				for(int k=j+1; k<7; k++) {
					if(arr[i] + arr[j] + arr[k] == total) {
						System.out.print(arr[i]+" "+arr[j]+" "+arr[k]);
					}
				}
			}
		}
		
		sc.close();
    }
}