import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int N;
	public static int[]arr= new int[MAX_N];
	public static int sum=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					if(arr[i]<= arr[j] && arr[j] <= arr[k]) {
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
		
		sc.close();
    }
}