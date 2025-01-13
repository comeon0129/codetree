import java.util.Scanner;

class Secret {
	char codeName;
	int score;
	
	
	Secret(char codeName, int score){
		this.codeName = codeName;
		this.score = score;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Secret[] agents = new Secret[5];
		for(int i=0; i<5; i++) {
			char codeName = sc.next().charAt(0);
			int score = sc.nextInt();
			agents[i] = new Secret(codeName,score);
		}
		int min = agents[0].score;
		for(int i=1; i<5; i++) {
			if(agents[i].score < min) {
				min = agents[i].score;
			}
		}
		for(int i=0; i<5; i++) {
			if(agents[i].score == min) {
				System.out.print(agents[i].codeName+" "+agents[i].score);
			}
		}
		
		
		sc.close();
    }
}