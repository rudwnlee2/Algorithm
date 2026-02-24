import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int[] dp = new int[10001];
		dp[0] = 1;
		
		for(int i = 1; i < 10001; i++) {
			dp[i] += dp[i - 1];
		}

		for(int i = 2; i < 10001; i++) {
			dp[i] += dp[i - 2];
		}

		for(int i = 3; i < 10001; i++) {
			dp[i] += dp[i - 3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);
	}
}