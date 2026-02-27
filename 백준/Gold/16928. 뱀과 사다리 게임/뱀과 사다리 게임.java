import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[101][1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][0] = y;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][0] = y;
		}

		boolean[] visited = new boolean[101];
		visited[1] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 0});

		int min = 0;
		while(!q.isEmpty()) {
			int[] temp = q.poll();

			if(temp[0] == 100) {
				min = temp[1];
				break;
			}

			for(int i = 1; i <= 6; i++) {
				int next = temp[0] + i;
				
				if(next > 100 || visited[next]) continue;

				if(board[next][0] != 0) {
					q.offer(new int[] {board[next][0], temp[1] + 1});
					visited[next] = true;
				} else {
					q.offer(new int[] {next, temp[1] + 1});
					visited[next] = true;
				}
			}
		}

		System.out.println(min);
	}
}