import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] mx = {-1, 1, 0, 0, 0, 0};
		int[] my = {0, 0, -1, 1, 0, 0};
		int[] mz = {0, 0, 0, 0, -1, 1};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][] arr = new int[h][m][n];

		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 1) {
						q.offer(new int[] {i, j, k, 0});
					}
				}
			}
		}
		
		int result = 0;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			result = temp[3];

			for(int i = 0; i < 6; i++) {
				int nz = mz[i] + temp[0];
				int ny = my[i] + temp[1];
				int nx = mx[i] + temp[2];
	
				if(nz < 0 || nz >= h || ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
				if(arr[nz][ny][nx] != 0) continue;

				arr[nz][ny][nx] = 1;
				q.offer(new int[] {nz, ny, nx, temp[3] + 1});
			}
		}

		for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(result);
	}
}