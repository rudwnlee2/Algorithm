import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result;
    
	public static void main(String args[]) throws Exception {
        int t = Integer.parseInt(br.readLine());
        
		for(int ts = 1; ts <= t; ts++) {
			result = 0;
            solution();
			System.out.println("#" + ts + " " + result);
		}
	}
    
    private static void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] arr =new int[n][2];
        int[] t = new int[n];
        int[] k = new int[n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            k[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[l + 1];
        for(int i = 0; i < n; i++) {
           for (int j = l; j >= k[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - k[i]] + t[i]);
            }
        }
        result = dp[l];
    }
}