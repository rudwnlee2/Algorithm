import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n];

		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(min);
	}


	static void dfs(int index, int count) {
		if(count == n / 2) {
			
			int start = 0;
			int link = 0;

			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					if(visited[i] && visited[j]) {
						start += (arr[i][j] + arr[j][i]);
					} else if (!visited[i] && !visited[j]) {
						link += (arr[i][j] + arr[j][i]);
					}
				}
			}

			int temp = Math.abs(start - link);
			min = Math.min(min, temp);
			
			return;
		}

		for(int i = index; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}
}