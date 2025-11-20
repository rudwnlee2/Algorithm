import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			int[] dy = {0, 1, 0, -1};
			int[] dx = {1, 0, -1, 0};
			int dir = 0;
			int num = 1;
			int y = 0;
			int x = 0;
			
			while(num <= n * n) {
				arr[y][x] = num;
				
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if(ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0) {
	                dir = (dir + 1) % 4;
	                ny = y + dy[dir];
	                nx = x + dx[dir];
	            }
				
				y = ny;
				x = nx;
				
				num++;
			}
			
			System.out.println("#" + test_case);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}