import java.io.*;
import java.util.*;

class Main {

	static boolean[] visited;
	static int[] arr;
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		arr = new int[m];
		
		dfs(1, 0);
	}

	static void dfs(int start, int count) {
		if(count == m) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for(int i = start; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[count] = i;
				dfs(i + 1, count + 1);
				visited[i] = false;
			}
			
		}
		
	}
	
}