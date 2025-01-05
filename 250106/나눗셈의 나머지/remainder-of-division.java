import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] numCount = new int[10];
        while(true) {
        	if(a <= 1) {
        		break;
        	}
        	numCount[a%b]++;
        	a = a / b;
        	
        }
        int ans = 0;
        for(int i=0; i<10; i++) {
        	if(numCount[i] != 0) {
        		ans += numCount[i]*numCount[i];
        	}
        }
        System.out.println(ans);
        
        sc.close();
    }
}