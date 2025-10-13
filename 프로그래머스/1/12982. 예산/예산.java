import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        int sum = 0;
        
        Arrays.sort(d);
        for(int temp : d) {
            if(sum + temp <= budget) {
                sum += temp;
                answer++;
            }
        }
        
        return answer;
    }
}