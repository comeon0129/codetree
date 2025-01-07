import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
       int[] arr = new int[100];    
       int idx =0;
       int max, min;
       
       for(int i=0; i<100; i++) {
    	   int num = sc.nextInt();
    	   if(num == 999 || num == -999) {
    		   break;
    	   }
    	   arr[i] = num;
    	   idx++;
       }
       
       max = arr[0];
       min = arr[0];
       
       for(int i =1; i< idx; i++) {
    	   if(max < arr[i])
    		   max =arr[i];
    	   if(min > arr[i])
    		   min = arr[i];
       }
       
       System.out.print(max+" "+min);
       
        sc.close();
    }
}