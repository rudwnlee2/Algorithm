import java.io.*;
import java.util.*;

class Main {

	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m][2];

		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{0, 0, 0, 1});
    visited[0][0][0] = true;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int b = now[2];
			int count = now[3];

			if (y == n - 1 && x == m - 1) return count;

			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
					
					if (arr[ny][nx] == 0 && !visited[ny][nx][b]) {
            visited[ny][nx][b] = true;
				    q.offer(new int[]{ny, nx, b, count + 1});
          }

					if(arr[ny][nx] == 1 && b == 0 && !visited[ny][nx][1]) {
						visited[ny][nx][1] = true;
				    q.offer(new int[]{ny, nx, 1, count + 1});
					}
					
				}
				
			}
			
		}

		return -1;
	}
	
}