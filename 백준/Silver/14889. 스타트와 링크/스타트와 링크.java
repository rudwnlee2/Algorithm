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
		
		back(0, 0);
		System.out.println(min);
	}

	private static void back(int start, int depth) {
		if(depth == n / 2) {
			int star = 0;
			int link = 0;

			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					if(visited[i] && visited[j]) {
						star += (arr[i][j] + arr[j][i]);
					} else if(!visited[i] && !visited[j]){
						link += (arr[i][j] + arr[j][i]);
					}
				}
			}

			min = Math.min(min, Math.abs(star - link));
			
			return;
		}

		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				back(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
	
}