import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int num = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        
        if(set.size() >= num) {
            return num;
        } else {
            return set.size();
        }
        
    }
}