import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[100001];

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		pq.offer(new int[] {n, 0});
		
		while(!pq.isEmpty()) {
			int[] x = pq.poll();
			visited[x[0]] = true;
			
			if(x[0] == k) {
				System.out.println(x[1]);
				break;
			}

			if(x[0] - 1 >= 0 && !visited[x[0] - 1]) {
				pq.offer(new int[] {x[0] - 1, x[1] + 1});
			}

			if(x[0] + 1 < 100001 && !visited[x[0] + 1]) {
				pq.offer(new int[] {x[0] + 1, x[1] + 1});
			}

			if(x[0] * 2 < 100001 && !visited[x[0] * 2]) {
				pq.offer(new int[] {x[0] * 2, x[1]});
			}
		}
		
	}
}