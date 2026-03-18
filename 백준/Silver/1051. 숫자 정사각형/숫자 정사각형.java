import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int len = 0;
				while(true) {
					if(i + len >= n || j + len >= m) break;
					if(arr[i][j] == arr[i + len][j] && arr[i][j] == arr[i][j + len] && arr[i][j] == arr[i + len][j + len]) {
						max = Math.max((len + 1) * (len + 1), max);
					}
					len++;
				}
			}
		}
		
		
		System.out.println(max);
	}
}