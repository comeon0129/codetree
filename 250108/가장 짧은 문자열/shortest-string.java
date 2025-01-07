import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s1 = sc.next();
    	String s2 = sc.next();
    	String s3 = sc.next();
    	
    	int a = s1.length();
    	int b = s2.length();
    	int c = s3.length();
    	
    	int maxVal,minVal;
    	
    	if(a>b) {
    		maxVal = a;
    		minVal = b;
    	}
    	else {
    		maxVal = b;
    	    minVal = a;
    	}
    	if (c>maxVal) {
    		maxVal = c;
    	}
    	else if (c<minVal) {
    		minVal = c;
    	}
    	

        System.out.println(maxVal-minVal);
        sc.close();
    }
}