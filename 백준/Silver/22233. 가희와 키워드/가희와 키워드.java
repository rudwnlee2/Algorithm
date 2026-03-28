import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			set.add(s);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			String[] arr = s.split(",");

			for(String temp : arr) {
				if(set.contains(temp)) {
					set.remove(temp);
				}
			}

			sb.append(set.size()).append("\n");
		}

		
		System.out.println(sb);
	}
}