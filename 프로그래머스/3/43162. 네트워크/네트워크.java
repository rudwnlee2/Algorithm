import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int index, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[index][i] == 1) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
    
}