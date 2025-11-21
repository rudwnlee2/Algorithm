import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int n;
	static int m;
	static int[][] arr;
	static int result;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		//0 북, 1 동, 2 남, 3서
		int dir = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		dfs(y, x, dir);
		System.out.println(result);
	}
	
	private static void dfs(int y, int x, int dir) {
		if(arr[y][x] == 0) {
			arr[y][x] = 2;
			result += 1;
		}
		
		for(int i = 0; i < 4; i++) {
			
			dir = (dir + 3) % 4;
			
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
			
			if(arr[ny][nx] == 2) {
				continue;
			} else {
				if(arr[ny][nx] == 0) {
					dfs(ny, nx, dir);
					return;
				}
			}
			
		}
		
		int backDir = (dir + 2) % 4;
		int by = y + dy[backDir];
		int bx = x + dx[backDir];
		
		if(by < 0 || bx < 0 || by >= n || bx >= m) return;;
		
		if(arr[by][bx] != 1) {
			dfs(by, bx, dir);
		} 
		
	}
	
}