import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<int[]>[] list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list[x].add(new int[] {y, d});
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a, b) -> a[1] - b[1]
		);
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		pq.offer(new int[] {start, 0});

		int[] visited = new int[n + 1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[start] = 0;

		int result = 0;
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int now = temp[0];
			int cost = temp[1];
			if(now == end) {
				result = cost;
				break;
			}

			for(int[] next : list[now]) {
				int sum = cost + next[1];
				
				if(visited[next[0]] <= sum) continue;

				visited[next[0]] = sum;
				pq.offer(new int[] {next[0], sum});
			}
		}
		
		System.out.println(result);
	}
}