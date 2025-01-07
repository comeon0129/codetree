import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][]arr2d = new int[2][4];
        
        int first_row = 0,second_row=0,first_col=0,second_col=0,third_col=0,fourth_col = 0;
        
        int sum =0;
  
       for(int i=0; i<2; i++) {
    	   for(int j=0; j<4; j++) {
    		   arr2d[i][j]= sc.nextInt();
    		   sum += arr2d[i][j];
    	   }
       }
       
      for(int i=0; i<4; i++) {
    	  first_row += arr2d[0][i];
    	  second_row +=arr2d[1][i];
      }
      
      for(int i=0; i<2; i++) {
    	  first_col += arr2d[i][0];
    	  second_col += arr2d[i][1];
    	  third_col += arr2d[i][2];
    	  fourth_col += arr2d[i][3];
      }
      System.out.printf("%.1f %.1f",(double)first_row/4,(double)second_row/4);
      System.out.println();
      System.out.printf("%.1f %.1f %.1f %.1f",(double)first_col/2,(double)second_col/2,(double)third_col/2,(double)fourth_col/2);
      System.out.println();
      System.out.printf("%.1f",(double)sum/8);
        sc.close();
    }
}