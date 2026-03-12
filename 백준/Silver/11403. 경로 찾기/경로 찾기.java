import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num ==1) {
					list.get(i).add(j);
				}
			}
		}

		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);

			while(!q.isEmpty()) {
				int num = q.poll();

				for(int next : list.get(num)) {
					if(visited[next]) continue;
					visited[next] = true;
					arr[i][next] = 1;
					q.offer(next);
				}
				
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int[] tempArr : arr) {
			for(int temp : tempArr) {
				sb.append(temp).append(" ");
			}

			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}