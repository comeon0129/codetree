import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       final int INT_MIN = Integer.MIN_VALUE;
       
       int maxVal = INT_MIN;
       
       for(int i=0; i<10; i++) {
    	   int num = sc.nextInt();
    	   if(num>maxVal) {
    		   maxVal = num;
    	   }
       }
       
       System.out.println(maxVal);
       
        
        sc.close();
    }
}
