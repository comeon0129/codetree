import java.util.Scanner;


public class Main {
	
	public static int n,t;  // n: 초기 숫자의 개수 t: t초
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        
        while(t-->0) {
        	int t1 = l[n-1];
        	int t2 = r[n-1];
        	int t3 = d[n-1];
        	
        	for(int i=n-1; i>=1; i--) {
        		l[i] = l[i-1];
        	}
        	l[0] = t3;
        	
        	for(int i=n-1; i>=1; i--) {
        		r[i] = r[i-1];
        	}
        	r[0] = t1;
        	
        	for(int i=n-1; i>=1; i--) {
        		d[i] = d[i-1];
        	}
        	d[0] = t2;
        }
        
        for(int i=0; i<n; i++) {
        	System.out.print(l[i]+" ");
        }
        System.out.println();
        
        for(int i=0; i<n; i++) {
        	System.out.print(r[i]+" ");
        }
        System.out.println();
        
        for(int i=0; i<n; i++) {
        	System.out.print(d[i]+" ");
        }
        System.out.println();
        
        
        sc.close();
    }
}