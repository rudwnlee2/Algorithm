import java.util.*;

class Solution {
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static int m;
    
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    private static int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            if(temp[0] == n - 1 && temp[1] == m - 1) {
                return temp[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int y = temp[0] + dy[i];
                int x = temp[1] + dx[i];
                int count = temp[2];
                
                if(y < 0 || x < 0 || y >= n || x >= m) {
                    continue;
                }
                
                if(visited[y][x]) {
                    continue;
                }
                
                if(maps[y][x] == 1) {
                    visited[y][x] = true;
                    q.offer(new int[] {y, x, count + 1});
                }
                
            }
        }
        
        return -1;
    }
}