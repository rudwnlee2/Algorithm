import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(temp[0] == n - 1 && temp[1] == m - 1) {
                return temp[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                
                if(ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if(visited[ny][nx] || maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                q.offer(new int[] {ny, nx, temp[2] + 1});
            }
        }
        
        return -1;
    }
}