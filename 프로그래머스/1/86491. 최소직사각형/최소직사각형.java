class Solution {
    public int solution(int[][] sizes) {    
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int min = Math.min(sizes[i][0], sizes[i][1]);
            int max = Math.max(sizes[i][0], sizes[i][1]);
            
            x = Math.max(min, x);
            y = Math.max(max, y);
        }
        
        
        return x * y;
    }
}