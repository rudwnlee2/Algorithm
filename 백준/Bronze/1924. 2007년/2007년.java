import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int day = 0;
		for(int i = 0; i < m; i++) {
			day += months[i];
		}

		day += d - 1;
		System.out.print(days[day % 7]);
	}
}