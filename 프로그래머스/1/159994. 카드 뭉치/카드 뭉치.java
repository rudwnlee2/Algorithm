import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        StringBuilder sb = new StringBuilder();
        
        Queue<String> q1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> q2 = new LinkedList<>(Arrays.asList(cards2));
        
        for(int i = 0; i < goal.length; i++) {
            if(goal[i].equals(q1.peek())) {
                q1.poll();
                continue;
            }
            if(goal[i].equals(q2.peek())) {
                q2.poll();
                continue;
            }
            return "No";
        }
        
        
        
        return answer;
    }
}