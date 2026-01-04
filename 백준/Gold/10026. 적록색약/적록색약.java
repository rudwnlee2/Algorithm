import java.io.*;
import java.util.*;

class Main {

	static char[][] arr;
	static int n;
	static int[] my = {-1, 1, 0, 0};
	static int[] mx = {0, 0, -1, 1};
	static boolean[][] visited;
	static char temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new char[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		int count1 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					temp = arr[i][j];
					visited[i][j] = true; //이거 빼먹음
					dfs1(i, j);
					count1 += 1;
				}
			}
		}

		visited = new boolean[n][n];
		int count2 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					temp = arr[i][j];
					dfs2(i, j);
					count2 += 1;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}

	//함수 1개로 할 수 있음 main에 2번째 for문에서 RG를 한개로 만들고 dfs
	private static void dfs1(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];

			if(ny >= n || nx >= n || ny < 0 || nx < 0) continue;
			if(visited[ny][nx]) continue;
			
			if(temp == arr[ny][nx]) {
				visited[ny][nx] = true;
				dfs1(ny, nx);
			}
		}
	}

	private static void dfs2(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];

			if(ny >= n || nx >= n || ny < 0 || nx < 0) continue;
			if(visited[ny][nx]) continue;
			
			if(temp == 'R' || temp == 'G') {
				if(arr[ny][nx] == 'R' || arr[ny][nx] == 'G') {
					visited[ny][nx] = true;
					dfs2(ny, nx);
				}
			} else {
				if(temp == arr[ny][nx]) {
					visited[ny][nx] = true;
					dfs2(ny, nx);
				}
			}
		}
	}
	
}