import java.util.Scanner;


public class Main {
	
	public static int n,t;  // n: 초기 숫자의 개수 t: t초
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		int[] top = new int[n];
		int[] bottom = new int[n];
		for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
		while(t-->0) {
			int temp1=top[n-1];
			int temp2= bottom[n-1];
			for(int i=n-1; i>=1; i--) {
				top[i] = top[i-1];
			}
			top[0] = temp2;
			
			for(int i=n-1; i>=1; i--) {
				bottom[i] = bottom[i-1];
			}
			bottom[0] = temp1;
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(top[i]+" ");
		}
		System.out.println();
		
		for(int i=0; i<n; i++) {
			System.out.print(bottom[i]+" ");
		}
		
		sc.close();
    }
}
