import java.util.*;

class Solution {
    public int[] numberGame(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                result[i + 1] = nums[i];
            } else {
                result[i - 1] = nums[i];
            }
        }
        
        return result;
    }
}