import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int odd_sum = 0;
        int even_sum = 0;
        
        for(int i=0; i<10; i++) {
        	arr[i] = sc.nextInt();
        	if(i%2==0)
        		odd_sum+=arr[i];
        	else
        		even_sum+=arr[i];
        }
        int ans = (odd_sum > even_sum) ? odd_sum-even_sum : even_sum-odd_sum;
        System.out.println(ans);
        
        
        
        sc.close();
    }
}
