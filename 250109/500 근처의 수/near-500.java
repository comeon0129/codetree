import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int max = -1;
    	int min = 100000;
    	for(int i=0; i<10; i++) {
    		int num = sc.nextInt();
    		
    		if(num < 500) {
    			if(num > max) {
    				max =num;
    			}
    		}
    		else if(num > 500) {
    			if(num < min) {
    				min = num;
    			}
    		}
    	}
    	System.out.print(max+" "+min);
    	
    		
    		
        sc.close();
    }
}