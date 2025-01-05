import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] personCnt = new int[4];
        
        for(int i=0; i<3; i++) {
        	char symptom = sc.next().charAt(0);
        	int temperature = sc.nextInt();
        	if(symptom=='Y' && temperature >=37)
        		personCnt[0]++;
        	else if(symptom=='N' && temperature >=37)
        		personCnt[1]++;
        	else if(symptom=='Y' && temperature <37)
        		personCnt[2]++;
        	else
        		personCnt[3]++;
        }
        
        for(int i=0; i<4; i++) {
        	System.out.print(personCnt[i]+" ");
        }
        
        if(personCnt[0] >= 2)
        	System.out.println("E");
        
        
        sc.close();
    }
}


