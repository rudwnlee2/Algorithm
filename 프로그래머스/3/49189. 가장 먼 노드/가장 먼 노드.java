import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        arr[1] = 0;
        
        int max = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            
            for (int i = 0; i < graph.get(temp).size(); i++) {
                int next = graph.get(temp).get(i);
                
                if (arr[next] == -1) {
                    arr[next] = arr[temp] + 1;
                    max = Math.max(max, arr[next]);
                    q.add(next);
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}