import java.io.*;
import java.util.*;

class Main {

	static int[][] graph;
    static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		visited = new boolean[n + 1];
		dfs(v);

		System.out.println();

		visited = new boolean[n + 1];
        bfs(v);
		
	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		if(v == graph.length) return;
		
		for (int i = 1; i < graph.length; i++) {
          if (graph[v][i] == 1 && !visited[i]) {
              dfs(i);
          }
        }
		
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
        visited[v] = true;
        System.out.print(v + " ");

		while(!q.isEmpty()) {
			int temp = q.poll();

			for (int i = 1; i < graph.length; i++) {
	          if (graph[temp][i] == 1 && !visited[i]) {
	              q.add(i);
                  visited[i] = true;
                  System.out.print(i + " ");
	          }
			}
		}
		
	}
}