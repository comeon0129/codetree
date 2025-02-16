import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		char[] arr = s.toCharArray();
		
		int ans = 1; 
		
		for(int len = 1; len<=100; len++) {
			boolean exit = true;
			String[] temp = new String[n];
			for(int i=0; i<n; i++) {
				temp[i] = "";
			}
			for(int i=0; i<=n-len; i++) {
				for(int j=i; j<i+len; j++) {
					temp[i] += arr[j];
				}
			}
			
			for(int i=0; i<=n-len; i++) {
				int cnt = 0;
				for(int j=i+1; j<=n-len; j++) {
					if(temp[i].equals(temp[j]))
						cnt++;
				}
				if(cnt >=1) {
					exit = false;
					break;
				}
			}
			
			if(exit) {
				ans = len;
				break;
			}
		}
	
		System.out.println(ans);
		
		sc.close();
    }
}