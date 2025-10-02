import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        Map<Integer, Integer> left = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            int temp = topping[i];
            
            left.put(temp, left.getOrDefault(temp, 0) + 1);
            
            right.put(temp, right.get(temp) - 1);
            if (right.get(temp) == 0) right.remove(temp);
            
            if (left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}