import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(s.length() > 1) {
            
            char[] temp = s.toCharArray();
            s = "";
            
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] == '0') {
                    answer[1]++;
                } else {
                    s += "1";
                }
            }
            
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        
        return answer;
    }
}