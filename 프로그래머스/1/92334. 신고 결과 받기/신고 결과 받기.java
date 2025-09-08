import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> index = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> set = new HashSet<>();
            map.put(id_list[i], set);
            index.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            map.get(temp[1]).add(temp[0]);
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> temp = map.get(id_list[i]);
            if(temp.size() >= k) {
                for (String s : temp) {
                    answer[index.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}