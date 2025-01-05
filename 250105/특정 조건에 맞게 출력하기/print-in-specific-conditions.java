import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        
        for(int i=0; i<100; i++) {
        	int num = sc.nextInt();
        	if(num == 0)
        		break;
        	if(num % 2 !=0) {
        		arr[i]=num+3;
        	}
        	else
        		arr[i] = num / 2;
        }
        
        for(int i =0; i<100; i++) {
        	if(arr[i] == 0) {
        		break;
        	}
        	System.out.print(arr[i]+" ");
        }
        
        
        
        
        
        sc.close();
    }
}
