import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[n + 1];
		
		for(int i = 1; i <= n; i++) {
			String temp = br.readLine();
			map.put(temp, i);
			arr[i] = temp;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(Character.isDigit(s.charAt(0))) {
				int num = Integer.parseInt(s);
				sb.append(arr[num]).append("\n");
			} else {
				sb.append(map.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}
}