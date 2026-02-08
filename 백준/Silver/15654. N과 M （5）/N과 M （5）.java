import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int m;

	static int[] arr;
	static boolean[] visited;
	static int[] result;

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];
		result = new int[m];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				result[depth] = arr[i];
				visited[i] = true;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}