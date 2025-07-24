import java.io.*;
import java.util.*;

class Main {

	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		for(int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr.get(x).add(y);
			arr.get(y).add(x);
		}

		int result = bfs(a, b);
		System.out.println(result);
		
	}

	static int bfs(int a, int b) {

		Queue<Integer> queue = new LinkedList<>();
		visited[a] = true;
		queue.add(a);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();

			for(int next : arr.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
          dist[next] = dist[now] + 1;
          queue.add(next);
				}
			}
		}

		if(dist[b] > 0) {
			return dist[b];
		}
		
		return -1;
	}
	
}