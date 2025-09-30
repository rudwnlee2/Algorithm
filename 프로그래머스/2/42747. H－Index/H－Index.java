import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            int n = citations.length - i;
            
            if (citations[i] >= n) {
                answer = n;
                break;
            }
            
        }
        
        return answer;
    }
}