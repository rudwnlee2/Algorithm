class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    static void dfs(int count, int k, int[][] dungeons) {
        
        for(int i = 0; i < dungeons.length; i++) {
            if(dungeons[i][0] > k || visited[i]) {
                continue;
            }
            
            visited[i] = true;
            dfs(count + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
            
        }
        
        answer = Math.max(count, answer);
    }
    
}