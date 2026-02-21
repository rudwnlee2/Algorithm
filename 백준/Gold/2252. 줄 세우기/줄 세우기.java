import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			arr[b]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 0) {
				q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");

			for(int next : list[now]) {
				arr[next]--;

				if(arr[next] == 0) {
					q.offer(next);
				}
			}
		}

		System.out.println(sb);
	}
}