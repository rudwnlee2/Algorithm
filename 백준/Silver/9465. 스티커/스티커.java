import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] arr1 = new int[n];
			for(int j = 0; j < n; j++) {
				arr1[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int[] arr2 = new int[n];
			for(int j = 0; j < n; j++) {
				arr2[j] = Integer.parseInt(st.nextToken());
			}

			if(n == 1) {
				sb.append(Math.max(arr1[0], arr2[0])).append("\n");
				continue;
			}

			int[][] dp = new int[n][2];
			dp[0][0] = arr1[0];
			dp[0][1] = arr2[0];
			dp[1][0] = arr2[0] + arr1[1];
			dp[1][1] = arr1[0] + arr2[1];
			
			for(int j = 2; j < n; j++) {
				dp[j][0] = Math.max(dp[j - 2][1], dp[j - 1][1]) + arr1[j];
				dp[j][1] = Math.max(dp[j - 2][0], dp[j - 1][0]) + arr2[j];
			}

			sb.append(Math.max(dp[n - 1][0], dp[n - 1][1])).append("\n");
		}

		System.out.println(sb);
	}
}