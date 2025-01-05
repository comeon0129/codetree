import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
        	int num = sc.nextInt();
        	if(num % 2 == 0 ) {
        		arr[cnt] = num;
        		cnt++;
        	}
        }
        for(int i=0; i<cnt; i++) {
        	System.out.print(arr[i]+" ");
        }
        
        
        sc.close();
    }
}