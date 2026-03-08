import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int m;

	static char[][] arr;
	static boolean[][] visited;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		visited = new boolean[n][m];

		int startY = 0;
		int startX = 0;
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = temp.charAt(j);
				if(arr[i][j] == 'I') {
					startY = i;
					startX = j;				
				}
			}
		}

		visited[startY][startX] = true;
		dfs(startY, startX);

		if(count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}

	public static void dfs(int y, int x) {
		if(arr[y][x] == 'P') {
			count++;
		}

		for(int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
			if(visited[ny][nx] || arr[ny][nx] =='X') continue;

			visited[ny][nx] = true;
			dfs(ny, nx);
		}
	}
}