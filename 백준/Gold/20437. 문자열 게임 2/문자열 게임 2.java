import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			String s = br.readLine();
			int num = Integer.parseInt(br.readLine());

			ArrayList<Integer>[] arr = new ArrayList[26];
			for(int j = 0; j < 26; j++) {
				arr[j] = new ArrayList<>();
			}

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int j = 0; j < s.length(); j++) {
				arr[s.charAt(j) - 97].add(j);
			}

			for(int j = 0; j < 26; j++) {
				if(arr[j].size() >= num) {
					for(int k = 0; k <= arr[j].size() - num; k++) {
						int len = arr[j].get(k + num - 1) - arr[j].get(k) + 1;
						min = Math.min(min, len);
						max = Math.max(max, len);
					}
				}
			}

			if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
				sb.append(-1);
			} else if(max == Integer.MIN_VALUE) {
				sb.append(min).append(" ").append(-1);
			} else {
				sb.append(min).append(" ").append(max);
			}
			sb.append("\n");
		}

		
		System.out.println(sb);
	}
}