import java.util.Scanner;

public class Main {
	public static int[] developers = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for(int i=0; i<6; i++) {
			developers[i] = sc.nextInt();
			total+= developers[i];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				for(int k=0; k<6; k++) {
					for(int l = 0; l<6; l++) {
						if(i == j || i==k || i==l || j==k || j==l || k==l)
							continue;
						int team1 = developers[i]+developers[j];
						int team2 = developers[k]+developers[l];
						int team3 = total- (team1+team2);
						int maxTeam = Math.max(team1, Math.max(team2, team3));
						int minTeam = Math.min(team1, Math.min(team2, team3));
						ans = Math.min(ans, maxTeam-minTeam);
					}
				}
			}
		}
		System.out.println(ans);
		sc.close();
    }
}
