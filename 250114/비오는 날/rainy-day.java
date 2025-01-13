import java.util.Scanner;

class Forecast {
	String date, day, weather;
	
	public Forecast(String date, String day, String weather) {
		this.date = date;
		this.day = day;
		this.weather = weather;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int idx =0;
		
		Forecast[] f = new Forecast[n];
		for(int i=0;i<n; i++) {
			String date  = sc.next();
			String day = sc.next();
			String weather  = sc.next();
			f[i] = new Forecast(date, day, weather);
			if(weather.equals("Rain")) {
				idx= i;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(!f[i].weather.equals("Rain")) {
				continue;
			}
			if(f[i].date.compareTo(f[idx].date) < 0) {
				idx =i;
			}
		}
		System.out.println(f[idx].date+" "+f[idx].day+" "+f[idx].weather);
		
		
		sc.close();
    }
}