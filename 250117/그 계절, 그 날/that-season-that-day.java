import java.util.Scanner;

public class Main {
	
    public static int y, m, d;
    
    
    public static boolean isYeun(int y) {
    	if(y % 4 == 0 && y % 100 == 0 && y % 400 == 0) {
    		return true;
    	}
    	else if(y% 4 == 0 && y % 100 == 0) {
    		return false;
    	}
    	else if(y%4 == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public static int lastDays(int y, int m) {
    	if(isYeun(y) && m ==2) {
    		return 29;
    	}
    	else if(!isYeun(y) && m == 2) {
    		return 28;
    	}
    	
    	if(m==1 || m ==3 || m==5 || m==7 || m ==8 || m==10 || m ==12) {
    		return 31;
    	}
    	else
    		return 30;
    }
    
    public static boolean isExist(int y, int m, int d) {
    	int lastDay = lastDays(y,m);
    	if(d<=lastDay) {
    		return true;
    	}
    	return false;
    }
    
    public static void printSeason(int m) {
    	if(m>=3 && m<=5) {
    		System.out.println("Spring");
    	}
    	else if(m>=6 && m<=8) {
    		System.out.println("Summer");
    	}
    	else if(m>=9 && m<=11) {
    		System.out.println("Fall");
    	}
    	else {
    		System.out.println("Winter");
    	}
    }
    
    
    
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        
        if(isExist(y,m,d)) {
        	printSeason(m);
        }
        else {
        	System.out.println("-1");
        }
        
        sc.close();
    }
}