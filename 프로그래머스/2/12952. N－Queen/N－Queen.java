class Solution {
    
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static int answer = 0;
    
    public int solution(int n) {
        
        col = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];
        
        dfs(0, n);
        
        return answer;
    }
    
    static void dfs(int x, int n) {
        
        if (x == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            
            if (col[i] || diag1[x + i] || diag2[x - i + n]) continue;
            
            col[i] = true;
            diag1[x + i] = true;
            diag2[x - i + n] = true;
            
            dfs(x + 1, n);
            
            col[i] = false;
            diag1[x + i] = false;
            diag2[x - i + n] = false;
        }
        
    }
}