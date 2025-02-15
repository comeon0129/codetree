import java.util.Scanner;

public class Main {
	public static int n;
	
	public static int[] x = new int[20];
	public static int[] y = new int[20];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		boolean flag = false;
		
		
		// case 1 . 세로선 3개로 지날 수 있는지 테스트
		for(int i =0; i<=10; i++) {
			for(int j=0; j<=10; j++) {
				for(int k=0; k<=10; k++) {
					int cnt =0;
					for(int l=0; l<n; l++) {
						if(x[l]==i || x[l] ==j || x[l] ==k ) {
							cnt++;
						}
					}
					if(cnt == n) {
						flag = true;
					}
				}
			}
		}
		// case 2. 세로선 2개 , 가로선 1개
		for(int i =0; i<=10; i++) {
			for(int j=0; j<=10; j++) {
				for(int k=0; k<=10; k++) {
					int[] isChecked = new int[n];
					int cnt =0;
					for(int l=0; l<n; l++) {
						if(x[l]==i || x[l] ==j) {
							cnt++;
							isChecked[l] = 1;
						}
					}
					for(int l=0; l<n; l++) {
						if(isChecked[l] !=0)
							continue;
						if(y[l] == k) {
							cnt++;
						}
					}
					if(cnt == n) {
						flag = true;
					}
				}
			}
		}
		// case 2. 세로선 1개 , 가로선 2개
		for(int i =0; i<=10; i++) {
			for(int j=0; j<=10; j++) {
				for(int k=0; k<=10; k++) {
					int[] isChecked = new int[n];
					int cnt =0;
					for(int l=0; l<n; l++) {
						if(x[l]==i) {
							cnt++;
							isChecked[l] = 1;
						}
					}
					for(int l=0; l<n; l++) {
						if(isChecked[l] !=0)
							continue;
						if(y[l] == j || y[l] == k) {
							cnt++;
						}
					}
					if(cnt == n) {
						flag = true;
					}
				}
			}
		}
		// case 3 . 가로선 3개로 지날 수 있는지 테스트
				for(int i =0; i<=10; i++) {
					for(int j=0; j<=10; j++) {
						for(int k=0; k<=10; k++) {
							int cnt =0;
							for(int l=0; l<n; l++) {
								if(y[l]==i || y[l] ==j || y[l] ==k ) {
									cnt++;
								}
							}
							if(cnt == n) {
								flag = true;
							}
						}
					}
				}
		
		
		if(flag) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
		sc.close();
    }
}