import java.io.*;
import java.util.*;

class Main {

	static int[][] arr;
	static int[] result = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, n);

		for(int i : result) {
			System.out.println(i);
		}
		
	}

	static void dfs(int y, int x, int size) {

		int temp = arr[y][x];
		boolean same = true;
		
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(arr[i][j] != temp) {
					same = false;
					break;
				}
			}
		}

		if(same) {
			result[temp + 1]++;
			return;
		}

		int newSize = size / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				dfs(y + i * newSize, x + j * newSize, newSize);
			}
		}
		
	}
	
}