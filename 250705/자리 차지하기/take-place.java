import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[n+1];
        
        for(int i=1; i<=n; i++) {
        	a[i] = sc.nextInt();
        }
        
        TreeSet<Integer> s = new TreeSet<>();
        
        for(int i=1; i<=m; i++) {
        	s.add(i);
        }
        
        
        int ans = 0;
        
        for(int i=1; i<=n; i++) {
        	if(s.floor(a[i]) == null)
        		break;
        	
        	s.remove(s.floor(a[i]));
        	ans++;
        }
        
       System.out.println(ans);
        
        sc.close();
    }
}