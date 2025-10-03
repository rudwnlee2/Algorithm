class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int size = brown + yellow;
        
        for(int i = 3; i <= size; i++) {
            
            if (size % i != 0) continue;
            int x = i;
            int y = size / x;
            
            if(y < 3) continue;
            
            if (x >= y) {
                if ((x - 2) * (y - 2) == yellow) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        
        return answer;
    }
}