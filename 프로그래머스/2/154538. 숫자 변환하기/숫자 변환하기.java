import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        int[] visited = new int[y + 1];
        Arrays.fill(visited, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = 0;
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            
            if(temp == y) return visited[y];
            
            if(temp + n <= y && visited[temp + n] == -1) {
                q.offer(temp + n);
                visited[temp + n] = visited[temp] + 1;
            }
            
            if(temp * 2 <= y && visited[temp * 2] == -1) {
                q.offer(temp * 2);
                visited[temp * 2] = visited[temp] + 1;
            }
            
            if(temp * 3 <= y && visited[temp * 3] == -1) {
                q.offer(temp * 3);
                visited[temp * 3] = visited[temp] + 1;
            }
        }
        
        return -1;
    }
}