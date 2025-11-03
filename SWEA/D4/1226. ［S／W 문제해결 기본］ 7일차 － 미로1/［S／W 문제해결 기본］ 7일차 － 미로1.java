import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    
    static int[] my = {-1, 1, 0, 0};
    static int[] mx = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception {
        
        for(int ts = 1; ts <= 10; ts++) {
            String t = br.readLine();
            int result = solution();
            System.out.println("#" + ts + " " + result);
        }
    }

    private static int solution() throws Exception {

        arr = new int[16][16];
        visited = new boolean[16][16];
        int startY = 0;
        int startX = 0;
        
        for(int i = 0; i < 16; i++ ) {
            String temp = br.readLine();
            for(int j = 0; j < 16; j++) {
                arr[i][j] = temp.charAt(j) - '0';
                
                if(arr[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }
        
        return bfs(startY, startX);
    }
    
    static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {startY, startX});
        
        visited[startY][startX] = true; 
        
        while(!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            
            for(int i = 0; i < 4; i++) {
                int ny = y + my[i]; 
                int nx = x + mx[i];
                
                if(ny < 0 || nx < 0 || ny >= 16 || nx >= 16) continue;
                
                if(arr[ny][nx] == 1 || visited[ny][nx]) continue;

                if(arr[ny][nx] == 3) return 1;

                visited[ny][nx] = true;
                queue.offer(new int[] {ny, nx});
            }
        }

        return 0; 
    }
}