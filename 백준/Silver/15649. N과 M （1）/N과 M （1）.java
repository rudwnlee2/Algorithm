import java.io.*;
import java.util.*;

class Main {

	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		arr = new int[m];

		dfs(0, n, m);
		
	}

	static void dfs(int now, int n, int m) {
		if(now == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[now] = i;
				dfs(now + 1, n, m);
				visited[i] = false;
			}
		}
		
	}
}