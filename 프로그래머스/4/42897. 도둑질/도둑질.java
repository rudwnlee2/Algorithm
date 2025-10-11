class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        
        int[] dp0 = new int[n];
        dp0[0] = money[0];
        dp0[1] = Math.max(money[0], money[1]);
        
        int[] dp1 = new int[n];
        dp1[0] = 0;
        dp1[1] = money[1];
        
        for(int i = 2; i < n - 1; i++) {
            dp0[i] = Math.max(dp0[i - 2] + money[i], dp0[i - 1]);
        }
        
        for(int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
        }
        
        answer = Math.max(dp0[n - 2], dp1[n - 1]);
        
        return answer;
    }
}