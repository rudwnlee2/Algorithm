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

		int count = 0;
		Set<String> result = new TreeSet<>();
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				count++;
				result.add(s);
			}
		}

		System.out.println(count);
		for(String s : result) {
			System.out.println(s);
		}
	}
}