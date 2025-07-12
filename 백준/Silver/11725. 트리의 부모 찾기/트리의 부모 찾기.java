import java.io.*;
import java.util.*;

class Main {

	static ArrayList<ArrayList<Integer>> array = new ArrayList<>();
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		parent = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			array.add(new ArrayList<>());
		}

		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			array.get(temp1).add(temp2);
			array.get(temp2).add(temp1);
			
		}

		dfs(1, 0);
		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
		
	}

	static void dfs(int now, int par) {
		
		visited[now] = true;
    parent[now] = par;

		for(int next : array.get(now)) {
			if (!visited[next]) {
            dfs(next, now);
      }
		}
		
	}
	
}