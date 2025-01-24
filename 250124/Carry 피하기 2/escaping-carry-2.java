import java.util.Scanner;


public class Main {
	
	public static int n;
	public static String[] numbers = new String[20];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			numbers[i] = sc.next();
		}
		for(int i=0; i<n; i++) {
			numbers[i] = String.format("%05d", Integer.parseInt(numbers[i]));
		}
		
		int ans = -1;
		
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					String a = numbers[i];
					String b = numbers[j];
					String c = numbers[k];
					int cnt = 0;
					for(int l=4; l>=0; l--) {
						int digitSum = (a.charAt(l) -'0') + (b.charAt(l) -'0')+ (c.charAt(l) -'0');
						if(digitSum >= 10) {
							break;
						}
						cnt++;
					}
					if(cnt == 5) {
						int num = Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c);
						ans = Math.max(ans, num);
					}
				}
			}
		}
		System.out.println(ans);
		sc.close();
    }
}