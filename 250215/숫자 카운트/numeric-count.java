import java.util.Scanner;

public class Main {
	public static final int MAX_N = 10;
	public static int n;
	
	public static int[] numbers = new int[MAX_N];
	public static int[] count1 = new int[MAX_N];
	public static int[] count2 = new int[MAX_N];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
			count1[i] = sc.nextInt();
			count2[i] = sc.nextInt();
		}
		int cnt =0;
		for(int i=100; i<1000; i++) {
			boolean flag =true;
			int[] temp1 = new int[n];
			int[] temp2 = new int[n];
			int[] numA = new int[3];
			numA[0] = i / 100;
			numA[1] = (i % 100) / 10;
			numA[2] = (i % 100) % 10;
			for(int j=0; j<n; j++) {
				int[] numB = new int[3];
				numB[0] = numbers[j] / 100;
				numB[1] = (numbers[j] % 100) / 10;
				numB[2] = (numbers[j] % 100) % 10;
				for(int k=0; k<3; k++) {
					for(int l=0; l<3; l++) {
						if(numA[k] == numB[l] && k == l) {
							temp1[j]++;
						}
						else if(numA[k] == numB[l]) {
							temp2[j]++;
						}
					}
				}
			}
			for(int j=0; j<n; j++) {
				if(temp1[j] != count1[j] || temp2[j] !=count2[j]) {
					flag = false;
					break;
				}
			}
			if(flag)
				cnt++;
		}
		System.out.println(cnt);
		
		sc.close();
    }
}
