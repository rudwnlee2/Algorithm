import java.io.*;
import java.util.*;

class Main {
	static int k;

	static int[] arr;
	static int[] result;

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;

			arr = new int[k];
			result = new int[6];

			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			dfs(0, 0);

			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static private void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = start; i < k; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
		
	}
}