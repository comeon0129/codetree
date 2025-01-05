import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100];
        int cnt = 0;
        int arr_index = 1;
        for(int i=1; i<100; i++) {
        	if(cnt == 2)
        		break;
        	arr[i] = n * i;
        	arr_index++;
        	if(arr[i] % 5 == 0) {
        		cnt++;
        	}
        }
        
        for(int i=1; i<arr_index; i++) {
        	System.out.print(arr[i]+" ");
        }
        
        
        sc.close();
    }
}
