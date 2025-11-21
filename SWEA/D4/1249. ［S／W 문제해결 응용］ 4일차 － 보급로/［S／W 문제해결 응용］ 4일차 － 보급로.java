import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		for(int ts = 1; ts<= t; ts++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int[][] cost = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				String s = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {0, 0, arr[0][0]});
			cost[0][0] = arr[0][0];
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int y = temp[0];
				int x = temp[1];
				int value = temp[2];
				
				if(cost[y][x] < value) continue;
				
				for(int i = 0; i < 4; i++) {
					int ny = dy[i] + y;
					int nx = dx[i] + x;
					
					if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
					
					int nextCost = value + arr[ny][nx];
					
					if(cost[ny][nx] > nextCost) {
						cost[ny][nx] = nextCost;
						q.offer(new int[] {ny, nx, nextCost});
					}
					
				}
				
			}
			
			System.out.println("#" + ts + " " + cost[n-1][n-1]);
		}
	}
}