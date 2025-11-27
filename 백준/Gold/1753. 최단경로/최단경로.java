import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] graph = new ArrayList[v + 1];
		for(int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[f].add(new int[]{t, w});
		}

		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		dist[start] = 0;
		pq.offer(new int[] {start, 0});

		while(!pq.isEmpty()) {
			int temp[] = pq.poll();
			int index = temp[0];
			int nowDist = temp[1];

			if(nowDist > dist[index]) continue;

			for(int[] n : graph[index]) {
				int next = n[0];
				int nextDist = n[1];

				if(dist[next] > nowDist + nextDist) {
					dist[next] = nowDist + nextDist;
					pq.add(new int[]{next, dist[next]});
				}
				
			}
		}

		for(int i = 1; i <= v; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		
	}
}