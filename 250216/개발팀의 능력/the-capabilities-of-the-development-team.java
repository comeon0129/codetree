import java.util.Scanner;

public class Main {
	public static int[] developers = new int[5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for(int i=0; i<5; i++) {
			developers[i]=sc.nextInt();
			total+= developers[i];
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<5; j++) {
				for(int k= 0; k<5; k++) {
					if(i == k || j == k)
						continue;
					int team1 =  developers[i]+developers[j];
					int team2 = developers[k];
					int team3 = total-(team1+team2);
					if(team1 == team2 || team2 == team3 || team1 == team3)
						continue;
					int minTeam = Math.min(team1, Math.min(team2, team3));
					int maxTeam = Math.max(team1, Math.max(team2, team3));
					ans = Math.min(ans, maxTeam-minTeam);
				}
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}