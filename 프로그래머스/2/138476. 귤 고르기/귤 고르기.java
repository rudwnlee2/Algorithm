import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[] { entry.getKey(), entry.getValue() });
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        
        int count = 0;
        
        for(int[] i : list) {
            if(k <= count) break;
            count += i[1];
            answer++;
        }
        
        return answer;
    }
}