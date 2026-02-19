import java.io.*;
import java.util.*;

class Main {

	static int r;
	static int c;

	static char[][] arr;
	static boolean[] visited;

	static int[] my = {-1, 1, 0, 0};
	static int[] mx = {0, 0, -1, 1};

	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];
		visited = new boolean[26];

		for(int i = 0 ; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		visited[arr[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

	private static void dfs(int y, int x, int depth) {
		max = Math.max(max, depth);

		for(int i = 0; i < 4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];

			if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;

			if(visited[arr[ny][nx] - 'A']) continue;

			visited[arr[ny][nx] - 'A'] = true;
			dfs(ny, nx, depth + 1);
			visited[arr[ny][nx] - 'A'] = false;
		}
	}
	
}