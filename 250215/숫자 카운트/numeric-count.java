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
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				for(int k=1; k<=9; k++) {
					if(i==j || j==k || i==k)
						continue;
					boolean flag =true;
					int[] temp1 = new int[n];
					int[] temp2 = new int[n];
					for(int l=0; l<n; l++) {
						int firstB = numbers[l] / 100;
						int secondB = (numbers[l] % 100) / 10;
						int thirdB = (numbers[l] % 100) % 10;
							
						if(firstB == i)
							temp1[l]++;
						if(secondB == j)
							temp1[l]++;
						if(thirdB == k)
							temp1[l]++;
						if(firstB == j ||  firstB == k)
							temp2[l]++;
						if(secondB == i ||  secondB == k)
							temp2[l]++;
						if(thirdB == i || thirdB == j)
							temp2[l]++;
					}
					
					for(int l=0; l<n; l++) {
						if(temp1[l] != count1[l] || temp2[l] !=count2[l]) {
							flag = false;
							break;
						}
					}
					if(flag)
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		sc.close();
    }
}