import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int weight = road[i][2];
            
            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        
        while(!q.isEmpty()) {
            Node now = q.remove();
            
            if (now.weight > dist[now.vertex]) continue;
            
            for(Node next : graph.get(now.vertex)) {
                int cost = next.weight + dist[now.vertex];
                
                if (cost < dist[next.vertex]) {
                    dist[next.vertex] = cost;
                    q.add(new Node(next.vertex, cost));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
}