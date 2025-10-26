import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result;
    
	public static void main(String args[]) throws Exception {
        
        int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
            result = 0;
            solution();
			System.out.println("#" + tc + " " + result);
		}
	}
    
    static void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }
        
        boolean[] dp = new boolean[max + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = max; j >= 0; j--) {
                if (dp[j] == true) {
                    if (j + arr[i] <= max) dp[j + arr[i]] = true;
                }
            }
        }
        
        for (int i = 0; i <= max; i++) {
            if (dp[i] == true) result++;
        }
        
    }
}