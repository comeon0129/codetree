import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100];
        arr[1] = n;
        arr[0] = 1;
        for(int i=2; i<100; i++) {
        	arr[i] = arr[i-1] + arr[i-2];
        	
        	if(arr[i] > 100)
        		break;
        }
        
        for(int i=0; i<100; i++) {
        	System.out.print(arr[i]+" ");
        	if(arr[i] > 100)
        		break;
        }
        
        sc.close();
    }
}
