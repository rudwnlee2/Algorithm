import java.io.*;
import java.util.*;

class Main {

	static int[][] arr;
	static int w = 0;
	static int h = 0;
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine()); 
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(h == 0&& w == 0) { break; }
			arr = new int[h][w];

			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
	}

	static void dfs(int y, int x) {
		arr[y][x] = 0;

		for(int i = 0; i < 8; i++) {
			
			int ny = y + dy[i];
      int nx = x + dx[i];
			
			if(ny >= 0 && ny < h && nx >= 0 && nx < w) {
				if(arr[ny][nx] == 1) {
					dfs(ny, nx);
				}
					
			}
			
		}
		
	}
	
}