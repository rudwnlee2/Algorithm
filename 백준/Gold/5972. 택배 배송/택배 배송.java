import java.io.*;
import java.util.*;

class Main {

	static int n;

	static ArrayList<int[]>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		arr = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr[a].add(new int[] {b, c});
			arr[b].add(new int[] {a, c});
		}

		int result = minCow(1, n);
		
		System.out.println(result);
	}

	private static int minCow(int start, int end) {
		int count = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[1] - b[1];
		});

		pq.offer(new int[] {start, 0});

		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int now = temp[0];
			int cowCount = temp[1];

			if(now == end) {
				count = cowCount;
				break;
			}

			visited[now] = true;
			for(int[] next : arr[now]) {
				if(visited[next[0]]) continue;
				pq.offer(new int[] {next[0], cowCount + next[1]});
			}
			
		}
		
		return count;
	}
	
}