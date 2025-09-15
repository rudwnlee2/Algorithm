import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] rx ={0, 0, -1, 1};
        int[] ry ={-1, 1, 0, 0};
        
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];
            
            if (y == maps.length - 1 && x == maps[0].length - 1) {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = y + ry[i];
                int nx = x + rx[i];
                
                if(ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length) {
                    continue;
                }
                
                if(visited[ny][nx]) {
                    continue;
                }
                
                if(maps[ny][nx] == 1) {
                    q.offer(new int[] {ny, nx, count + 1});
                    visited[ny][nx] = true;
                }
            }
            
        }
        
        return -1;
    }
}