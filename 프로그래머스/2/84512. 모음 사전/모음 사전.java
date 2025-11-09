import java.util.*;

class Solution {
    
    static char[] c = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list;
    
    public int solution(String word) {
        list = new ArrayList<>();
        
        dfs("", 0);
        Collections.sort(list);
        int answer = list.indexOf(word) + 1;
        
        return answer;
    }
    
    private static void dfs(String s, int index) {
        if(index >= 5) return;
        
        for(int i = 0; i < c.length; i++) {
            list.add(s + c[i]);
            dfs(s + c[i], index + 1);
        }
    }
}