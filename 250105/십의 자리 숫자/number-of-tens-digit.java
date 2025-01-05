import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numCount = new int[10];
        while(true) {
        	int num =sc.nextInt();
        	if(num == 0) {
        		break;
        	}
        	numCount[num/10]++;
        }
        for(int i=1; i<10; i++) {
        	System.out.println(i+" - "+numCount[i]);
        }
   
        
        sc.close();
    }
}