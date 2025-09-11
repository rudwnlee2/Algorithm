import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, Integer> index = new HashMap<>();
        HashMap<String, HashSet> reportsCount = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
            reportsCount.put(id_list[i], new HashSet());
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            reportsCount.get(temp[1]).add(temp[0]);
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> set = reportsCount.get(id_list[i]);
            if(set.size() >= k) {
                for (String s : set) {
                    answer[index.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}