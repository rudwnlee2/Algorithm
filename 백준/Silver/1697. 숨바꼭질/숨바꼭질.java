import java.io.*;
import java.util.*;

class Main {

	static boolean[] visited = new boolean[1000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int result = bfs(n, k, 0);
		System.out.println(result);
	}

	static int bfs(int subin, int brother, int time) {
		Queue<int[]> queue = new LinkedList<>();
		visited[subin] = true;
		queue.offer(new int[]{subin, brother, time});

		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int now = temp[0];
			int end = temp[1];
			int qTime = temp[2];

			if(now == end) return qTime;

			if(now - 1 >= 0 && now - 1 <= 100000 && !visited[now - 1]) {
				visited[now - 1] = true;
				queue.offer(new int[]{now - 1, end, qTime + 1});
			}

			if(now + 1 >= 0 && now + 1 <= 100000 && !visited[now + 1]) {
				visited[now + 1] = true;
				queue.offer(new int[]{now + 1, end, qTime + 1});
			}

			if(now * 2 >= 0 && now * 2 <= 100000 && !visited[now * 2]) {
				visited[now * 2] = true;
				queue.offer(new int[]{now * 2, end, qTime + 1});
			}
			
		}

		return -1;
	}
	
}