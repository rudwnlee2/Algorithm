import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] visited = new int[f + 1];
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		visited[s] = 0;

		while(!q.isEmpty()) {
			int ns = q.poll();
			
			if(ns == g) {
				break;
			}

			if(ns + u <= f && visited[ns + u] == -1) {
				q.offer(ns + u);
				visited[ns + u] = visited[ns] + 1;
			}

			if(ns - d > 0 && visited[ns - d] == -1) {
				q.offer(ns - d);
				visited[ns - d] = visited[ns] + 1;
			}
		}

		if(visited[g] == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(visited[g]);
		}
		
	}
}