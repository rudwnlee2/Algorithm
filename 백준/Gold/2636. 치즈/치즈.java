import java.io.*;
import java.util.*;

class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] arr;
	static boolean[][] visited;
	static int n, m;
	static int cheese;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) cheese++;
			}
		}

		int time = 0;
		int cheeseCount = 0;
		while(cheese != 0) {
			cheeseCount = cheese;
      time++;
      visited = new boolean[n][m];
      bfs();
		}

		System.out.println(time);
		System.out.println(cheeseCount);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {0, 0});
		visited[0][0] = true;

		while(!queue.isEmpty()) {
			int[] c = queue.poll();

			for(int i = 0; i < 4; i++) {
				int ny = c[0] + dy[i];
				int nx = c[1] + dx[i];

				if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
				if(visited[ny][nx]) continue;

				visited[ny][nx] = true;
				if(arr[ny][nx] == 0) {
					queue.offer(new int[] {ny, nx});
				} else {
					cheese--;
					arr[ny][nx] = 0;
				}

			}
				
		}
			
	}
	
}