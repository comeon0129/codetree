import java.util.Scanner;


public class Main {
	
	public static int n,t;  // n: 초기 숫자의 개수 t: t초
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        
        int[] temp = new int[n];
        
        int tempIdx = 0;
        for(int i=0; i<n; i++) {
        	if(i+1 <s1 || i+1 > e1) {
        		temp[tempIdx] = blocks[i];
        		tempIdx++;
        	}
        }
        
        blocks = temp;
        
        temp = new int[n];
        tempIdx = 0;
        for(int i=0; i<n; i++) {
        	if(blocks[i] != 0 && (i+1 <s2 || i+1 > e2)) {
        		temp[tempIdx] = blocks[i];
        		tempIdx++;
        	}
        }
        blocks = temp;
        
        System.out.println(tempIdx);
        for(int i=0; i<n; i++) {
        	if(blocks[i] != 0)
        		System.out.println(blocks[i]);
        }
        
        
        
        
        sc.close();
        
    }
}
