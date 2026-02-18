import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();

			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				String value = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}

			int count = 1;
		
			for(int temp : map.values()) {
				count *= (temp + 1);
			}
			
			System.out.println(count - 1);			
		}

	}
}