class Solution {
    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        int[] dp = {0, 1};
        
        for(int i = 2; i <= n; i++) {
            int temp = (dp[0] + dp[1]) % 1234567;
            dp[0] = dp[1];
            dp[1] = temp;
        }
        
        return dp[1];
    }
}