import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> index = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < seller.length; i++) {
            
            String now = seller[i];
            int money = amount[i] * 100;
            
             while(!now.equals("-")){
                 int parent =  money / 10;
                 int me = money - parent;
                 answer[index.get(now)] += me;
                 
                 now = map.get(now);
                 money /= 10;
                 
                 if (money < 1) {
                    break;
                }
             }
            
        }
        
        
        return answer;
    }
}