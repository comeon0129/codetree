import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numCount = new int[20];
        while(true) {
        	int num =sc.nextInt();
        	if(num == 0) {
        		break;
        	}
        	numCount[num/10]++;
        }
        for(int i=10; i>=1; i--) {
        	System.out.println(10*i+" - "+numCount[i]);
        }
   
        
        sc.close();
    }
}

