import java.io.*;
import java.util.*;

class Main {

	static int[][] arr;
	static int n;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		int y = 0;
		int x = 0;
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					y = i;
					x = j;
					arr[i][j] = 0;
				}
			}
		}

		int count = bfs(y, x);
		System.out.println(count);
	}

	public static int bfs(int startY, int startX) {
		int result = 0;
		int size = 2;
		int eat = 0;
		
		int y = startY;
		int x = startX;

		while(true) {
			
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];

			q.offer(new int[] {y, x, 0});
			visited[y][x] = true;
			
			int targetY = Integer.MAX_VALUE;
			int targetX = Integer.MAX_VALUE;
			int minDist = Integer.MAX_VALUE;
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int ny = temp[0] + dy[i];
					int nx = temp[1] + dx[i];

					if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
					if(visited[ny][nx] || arr[ny][nx] > size) continue;

					visited[ny][nx] = true;

					if(arr[ny][nx] != 0 && arr[ny][nx] < size) {
						if(temp[2] + 1 < minDist) {
							minDist = temp[2] + 1;
							targetY = ny;
							targetX = nx;
						} else if(temp[2] + 1 == minDist) {
							if(ny < targetY || (ny == targetY && nx < targetX)) {
								targetY = ny;
								targetX = nx;
							}
						}
					}
					
					q.offer(new int[] {ny, nx, temp[2] + 1});
				}
					
			}

			if(minDist == Integer.MAX_VALUE) break;

			result += minDist;
			y = targetY;
			x = targetX;
			arr[y][x] = 0;
			eat++;

			if(eat == size) {
				size++;
				eat = 0;
			}

		}

		return result;
	}
}