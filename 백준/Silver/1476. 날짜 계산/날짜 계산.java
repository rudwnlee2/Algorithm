import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int countE = 0;
		int countS = 0;
		int countM = 0;

		int count = 0;

		while(true) {
			countE++;
			countS++;
			countM++;

			count++;

			if (countE == 16) countE = 1;
			if (countS == 29) countS = 1;
			if (countM == 20) countM = 1;

			if(countE == e && countS == s && countM == m) break;
			
		}
		
		System.out.println(count);
	}
}