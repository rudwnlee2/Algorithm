import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            count += number[i];
        }
        
        for(int i = 0; i < 10; i++) {
            if(map.containsKey(discount[i])) {
                if(map.get(discount[i])>0) count--;
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        
        if(count == 0) answer++;
        
        for(int i = 10; i < discount.length; i++) {
            String out = discount[i - 10];
            if (map.containsKey(out)) {
                map.put(out, map.get(out) + 1);
                if (map.get(out) > 0) count++;
            }
            
            String in = discount[i];
            if (map.containsKey(in)) {
                if (map.get(in) > 0) count--;
                map.put(in, map.get(in) - 1);
            }
            
            if(count == 0) answer++;
        }
        
        return answer;
    }
}