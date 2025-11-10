class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if(num == 1 || num == 4 || num == 7) {
                left = num;
                answer += "L";
            } else if(num == 3 || num == 6 || num == 9) {
                right = num;
                answer += "R";
            } else {
                
                if (num == 0) num = 11;
                
                int leftDist = Math.abs(num - left) / 3 + Math.abs(num - left) % 3;
                int rightDist = Math.abs(num - right) / 3 + Math.abs(num - right) % 3;
                
                if(leftDist < rightDist) {
                    left = num;
                    answer += "L";
                } else if(leftDist > rightDist) {
                    right = num;
                    answer += "R";
                } else {
                    if(hand.equals("left")) {
                        left = num;
                        answer += "L";
                    } else {
                        right = num;
                        answer += "R";
                    }
                }
            }
            
        }
        
        return answer;
    }
}