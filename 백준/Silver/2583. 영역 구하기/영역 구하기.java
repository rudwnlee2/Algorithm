import java.io.*;
import java.util.*;

class Main {
	static boolean[][] arr;
	static int n;
	static int m;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new boolean[m][n];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					arr[y][x] = true;
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!arr[i][j]) {
					int temp = dfs(i, j);
					result.add(temp);
				}
			}
		}

		Collections.sort(result);

		String answer = "";
		for(int i = 0; i < result.size(); i++) {
			answer = answer + result.get(i) + " ";
		}

		System.out.println(result.size());
		System.out.println(answer);
	}

	private static int dfs(int y, int x) {
		arr[y][x] = true;
		int size = 1;

		for(int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;

			if(!arr[ny][nx]) {
				size += dfs(ny, nx);
			}
		}

		return size;
	}
	
}