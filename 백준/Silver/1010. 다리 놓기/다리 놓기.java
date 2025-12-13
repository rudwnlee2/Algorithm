import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int result = 1;
			for(int j = 0; j < n; j++) {
				result = result * (m - j);
				result = result / (j + 1);
			}

			System.out.println(result);
		}
	}
}