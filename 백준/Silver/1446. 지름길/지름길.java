import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[10001];
		ArrayList<int[]>[] arr = new ArrayList[10001];
		for(int i = 0; i < 10001; i++) {
			arr[i] = new ArrayList<>();
		}

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			arr[start].add(new int[] {end, len});
		}

		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[1] - b[1];
		});
		
		pq.offer(new int[] {0, 0});
		int count = 0;
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			
			if(temp[0] == d) {
				count = temp[1];
				break;
			}
			visited[temp[0]] = true;

			if(!arr[temp[0]].isEmpty()) {
				for(int[] x : arr[temp[0]]) {
					if(x[0] > d) continue;
					pq.offer(new int[] {x[0], temp[1] + x[1]});
				}
			}
			
			int next = temp[0] + 1;

			if(next < 0 || next > 10000) continue;
			if(visited[next]) continue;

			pq.offer(new int[] {next, temp[1] + 1});
		}
		
		System.out.println(count);
	}
}