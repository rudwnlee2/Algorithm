import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] before = new int[n + 1];

		for(int i = 2; i <= n; i++) {
			
			dp[i] = dp[i -1] + 1;
			before[i] = i - 1;
			
			if(i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				before[i] = i / 2;
			} 
			if(i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				before[i] = i / 3;
			} 
			
		}

		StringBuilder sb = new StringBuilder();
		int x = n;
		while(x != 0) {
			sb.append(x).append(" ");
			if (x == 1) break;
			x = before[x];
		}

		System.out.println(dp[n]);
		System.out.println(sb.toString());
		
	}
}