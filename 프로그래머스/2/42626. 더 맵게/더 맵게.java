import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.offer(i);
        }
        
        while(true) {
            if(pq.size() == 1) break;
            int a = pq.poll();
            
            if(a >= K) break;
            int b = pq.poll();
            
            pq.offer(a + b * 2);
            answer++;
        }
        
        if(pq.poll() < K) {
            answer = -1;
        }
        
        return answer;
    }
}