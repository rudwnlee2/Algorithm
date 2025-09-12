import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    List<String> answerList = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {

        for(int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        for(int i : course) {
            
            for(String s : orders) {
                dfs("", s, i);
            }
            
            if(!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if(max > 1) {
                    for(String k : map.keySet()) {
                        if (map.get(k) == max) answerList.add(k);
                    }
                }
                
                map.clear();
            }
            
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    
    public void dfs(String order, String others, int count) {
        if(count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for (int i = 0; i < others.length(); i++) {
            dfs(order + others.charAt(i), others.substring(i + 1), count - 1);
        }

    }
}