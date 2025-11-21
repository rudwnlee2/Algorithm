import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		arr[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int y = temp[0];
			int x = temp[1];
			int count = temp[2];
			
			if(y == n - 1 && x == m - 1) {
				result = count;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = dy[i] + y;
				int nx = dx[i] + x;
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
				
				if(arr[ny][nx] == 1) {
					arr[ny][nx] = 0;
					q.offer(new int[] {ny, nx, count + 1});
				}
			}
		}
		
		
		System.out.println(result);
	}
	
}