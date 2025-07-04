import java.io.*;
import java.util.*;

class Main {

	static boolean[][] visited;
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int endR = Integer.parseInt(st.nextToken());
		int endC = Integer.parseInt(st.nextToken());

		int min = bfs(startR, startC, endR, endC);
		System.out.println(min);
		
	}

	public static int bfs(int startR, int startC, int endR, int endC) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startR, startC, 0});
		visited[startR][startC] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			int count = now[2];

			if (r == endR && c == endC) return count;

			for(int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if(nr < visited.length && nc < visited.length && nr >= 0 && nc >= 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[]{nr, nc, count + 1});
				}
			}
			
		}

		return -1;
		
	}
	
}