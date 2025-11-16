import java.io.*;
import java.util.*;

class Main {

	static int[] ny = {-1, 1, 0, 0};
	static int[] nx = {0, 0, -1, 1};
	static int[][] arr;
	static int n;
	static int m;
	static int answer;
	
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
			}
		}

		answer = 0;
		dfs(0);

		System.out.println(answer);
	}

	private static void dfs(int wall) {
		if(wall ==3) {
			bfs();
			return;
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(wall + 1);
					arr[i][j] = 0;
				}
			}
		}
		
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}

		int[][] copyArr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}

		while(!q.isEmpty()) {
			int[] temp = q.poll();

			for(int i = 0; i < 4; i++) {
				int y = temp[0] + ny[i];
				int x = temp[1] + nx[i];

				if(y < 0 || x < 0 || y >= n || x >= m) continue;
				
				if(copyArr[y][x] == 0) {
					copyArr[y][x] = 2;
					q.offer(new int[] {y, x});
				}
			}
		}

		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copyArr[i][j] == 0) {
					count += 1;
				}
			}
		}

		answer = Math.max(answer, count);
	}
	
}