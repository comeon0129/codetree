import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] arr = new int[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.next().charAt(0) - 'A';
		}
		
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		sc.close();
    }
}