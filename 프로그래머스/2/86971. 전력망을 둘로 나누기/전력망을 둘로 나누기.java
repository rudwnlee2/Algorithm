import java.util.*;

class Solution {
    
    static int[][] graph;
    
    public int solution(int n, int[][] wires) {
        
        int answer = n;
        graph = new int[n + 1][n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            
            graph[x][y] = 0;
            graph[y][x] = 0;
            
            answer = Math.min(answer, bfs(n, x));
            
            graph[x][y] = 1;
            graph[y][x] = 1;
            
        }
        
        return answer;
    }
    
    public static int bfs(int n, int x) {
        
        boolean[] visited = new boolean[n + 1];
        int count = 1;
        
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.offer(x);
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            
            for(int i = 1; i <= n; i++) {
                if(graph[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count ++;
                }
            }
        }
        
        return (int)Math.abs(count - (n - count));
    }
}