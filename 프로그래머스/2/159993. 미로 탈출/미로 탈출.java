import java.util.*;

class Solution {
    public int solution(String[] maps) {
        
        int n = maps.length;
        int m = maps[0].length();
        char[][] arr = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] rx = {0, 0, -1, 1};
        int[] ry = {-1, 1, 0, 0};
        
        for(int i = 0; i < n; i++) {
            arr[i] = maps[i].toCharArray();
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            boolean temp = false;
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'S') {
                    q.offer(new int[] {i, j, 0});
                    visited[i][j] = true;
                    temp = true;
                    break;
                }
            }
            if(temp) break;
        }
        
        int my = -1;
        int mx = -1;
        int total = -1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];
            
            if(arr[y][x] == 'L') {
                my = y;
                mx = x;
                total = count;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = ry[i] + y;
                int nx = rx[i] + x;
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                
                if(arr[ny][nx] != 'X' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, count + 1});
                }

            }
        }
 
        if (my == -1 || mx == -1) {
            return -1;
        }
        
        q.clear();
        visited = new boolean[n][m];
        visited[my][mx] = true;
        q.offer(new int[] {my, mx, total});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];
            
            if(arr[y][x] == 'E') {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = ry[i] + y;
                int nx = rx[i] + x;
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                
                if(arr[ny][nx] != 'X' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, count + 1});
                }

            }
        }

        return -1;
    }
}