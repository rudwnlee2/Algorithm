import java.io.*;
import java.util.*;

class Main {
	static int n;
	static int[][] arr;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		int max = 0;
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}

		int result = 1;

		for(int h = 1; h < max; h++) {
			visited = new boolean[n][n];
			int count = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j] && arr[i][j] > h) {
						dfs(i, j, h);
						count += 1;
					}
				}
			}
			result = Math.max(result, count);
		}
		
		System.out.println(result);
	}

	private static void dfs(int y, int x, int h) {
		
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

			if(!visited[ny][nx] && arr[ny][nx] > h) {
				dfs(ny, nx, h);
			}

		}
	}
	
}