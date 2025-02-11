import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
	public static int[] sums = new int[15];
	
	public static int[] myArr = new int[15];
	
	public static boolean isEqualArray() {
		Arrays.sort(sums);
		Arrays.sort(myArr);
		for(int i=0; i<15; i++) {
			if(sums[i] != myArr[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<15; i++) {
			sums[i] = sc.nextInt();
		}
		for(int a=1; a<=40; a++) {
			for(int b=a; b<=40; b++) {
				for(int c=b; c<=40; c++) {
					for(int d = c; d<=40; d++) {
						myArr[0]=a;
						myArr[1]=b;
						myArr[2]=c;
						myArr[3]=d;
						myArr[4]=a+b;
						myArr[5]=b+c;
						myArr[6]=c+d;
						myArr[7]=d+a;
						myArr[8]=a+c;
						myArr[9]=b+d;
						myArr[10]=a+b+c;
						myArr[11]=a+b+d;
						myArr[12]=a+c+d;
						myArr[13]=b+c+d;
						myArr[14]=a+b+c+d;
						if(isEqualArray()) {
							System.out.println(a+" "+b+" "+c+" "+d);
						}
					}
				}
			}
		}
	
	
		sc.close();
    }
}