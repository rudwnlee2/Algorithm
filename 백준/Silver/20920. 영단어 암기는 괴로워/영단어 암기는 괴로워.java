import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s.length() < m) continue;
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		List<String> list = new ArrayList<>(map.keySet());

		Collections.sort(list, (a, b) -> {
			int countA = map.get(a);
			int countB = map.get(b);
			
			if(countA != countB) {
				return countB - countA;
			} else {
				if(a.length() != b.length()) {
					return b.length() - a.length();
				} else {
					return a.compareTo(b);
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}
}