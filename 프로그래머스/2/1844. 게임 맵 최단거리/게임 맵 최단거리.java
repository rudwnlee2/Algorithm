import java.util.*;

class Solution {
    
    static int[] rx ={0, 0, -1, 1};
    static int[] ry ={-1, 1, 0, 0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];
            
            if (y == n - 1 && x == m - 1) {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = y + ry[i];
                int nx = x + rx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                
                if(visited[ny][nx]) {
                    continue;
                }
                
                if(maps[ny][nx] == 1) {
                    queue.add(new int[] {ny, nx, count + 1});
                    visited[ny][nx] = true;
                }
            }
            
        }
        
        return -1;
    }
}