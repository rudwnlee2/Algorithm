import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<String, Integer> num = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            
            if(!map.containsKey(genres[i])) {
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                map.put(genres[i], temp);
                num.put(genres[i], plays[i]);
            } else {
                map.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
            
        }
        
        List<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1)));
        
        List<Integer> li = new ArrayList<>();
        for(String key : keySet) {
            HashMap<Integer, Integer> temp = map.get(key);
            List<Integer> list = new ArrayList(temp.keySet());
            
            Collections.sort(list, (s1, s2) -> temp.get(s2) - (temp.get(s1)));
            
            li.add(list.get(0));
            if(list.size() > 1)
                li.add(list.get(1));
        }
        
        int[] answer = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            answer[i] = li.get(i);
        }
        
        return answer;
    }
}