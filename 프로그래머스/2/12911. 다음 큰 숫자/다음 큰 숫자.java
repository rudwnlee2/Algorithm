class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        
        int count = oneCount(s);
        
        while(true) {
            n++;
            s = Integer.toBinaryString(n);
            
            if(count == oneCount(s)) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
    
    private static int oneCount(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
        }
        
        return count;
    }
}