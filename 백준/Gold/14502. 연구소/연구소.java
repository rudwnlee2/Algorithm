import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int m;
	static int[][] arr;

	static int[] my = {-1, 1, 0, 0};
	static int[] mx = {0, 0, -1, 1};

	static int max = 0;
	
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

		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int count) {
		if(count == 3) {
			bfs();
			return;
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(count + 1);
					arr[i][j] = 0;
				}
			}
		}
		
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		int[][] newArr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				newArr[i][j] = arr[i][j];
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(newArr[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}

		while(!q.isEmpty()) {
			int[] temp = q.poll();

			for(int i = 0; i < 4; i++) {
				int y = my[i] + temp[0];
				int x = mx[i] + temp[1];

				if(y >= n || x >= m || y < 0 || x < 0) continue;

				if(newArr[y][x] == 1 || newArr[y][x] == 2) continue;

				newArr[y][x] = 2;
				q.offer(new int[] {y, x});
			}
			
		}

		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(newArr[i][j] == 0) count++;
			}
		}

		max = Math.max(max, count);
	}
	
}