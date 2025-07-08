import java.io.*;
import java.util.*;

class Main {

	static boolean[] visited = new boolean[101];
	static Map<Integer, Integer> moveMap = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			moveMap.put(start, end);
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			moveMap.put(start, end);
			
		}
		
		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {1, 0});

		visited[1] = true;

		while(!queue.isEmpty()){
			int[] now = queue.poll();
			int pos = now[0];
			int count = now[1];

			if (pos == 100) return count;

			for(int i = 1; i <= 6; i++) {
				int next = pos + i;

				if (next > 100) continue;
				if (visited[next]) continue;
				
				if (moveMap.containsKey(next)) {
					next = moveMap.get(next);
        }

				if (!visited[next]) {
          visited[next] = true;
          queue.offer(new int[] {next, count + 1});
        }
				
			}
			
		}

		return -1;
		
	}
}