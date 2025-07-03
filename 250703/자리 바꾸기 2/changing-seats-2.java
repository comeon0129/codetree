import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static int n,k;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
       
        int[] seats = new int[n+1];
        for(int i=1; i<=n; i++) {
        	seats[i] = i;
        }
        HashSet<Integer>[] hashSets = new HashSet[n+1];
        
        for(int i=1; i<=n; i++) {
        	hashSets[i] = new HashSet<Integer>();
        	hashSets[i].add(i);
        }
        
        int[] a = new int[k+1];
        int[] b = new int[k+1];
        
        for(int i=1; i<=k; i++) {
        	a[i] = sc.nextInt();
        	b[i] = sc.nextInt();
        }


        for(int i=0; i<3; i++) {
        	for(int j=1; j<=k; j++) {
        		hashSets[seats[a[j]]].add(b[j]);
        		hashSets[seats[b[j]]].add(a[j]);
        		
        		int temp = seats[a[j]];
        		seats[a[j]] = seats[b[j]];
        		seats[b[j]] = temp;
        	}
        }
        
        for(int i=1; i<=n; i++)
        	System.out.println(hashSets[i].size());
        
        sc.close();
    }
}