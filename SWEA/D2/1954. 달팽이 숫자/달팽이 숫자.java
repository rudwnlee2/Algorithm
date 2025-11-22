import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		
		
		for(int ts = 1; ts <= t; ts++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			int dir = 0;
			int num = 1;
			int y = 0;
			int x = 0;
			
			while(num <= n * n) {
				arr[y][x] = num;
				
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= n || arr[ny][nx] != 0) {
					dir = (dir + 1) % 4;
					ny = y + dy[dir];
					nx = x + dx[dir];
				}
				
				y = ny;
				x = nx;
				
				num++;
			}
			
			System.out.println("#" + ts);
			for(int[] temp1 : arr) {
				for(int temp2 : temp1) {
					System.out.print(temp2 + " ");
				}
				System.out.println();
			}
			
		}
	}
}