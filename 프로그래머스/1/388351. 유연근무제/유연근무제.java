class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            minute += 10;
            
            if (minute >= 60) {
                hour++;
                minute -= 60;
            }
            int temp = (hour * 100) + minute;
            boolean ckeck = true;
            
            for(int j = 0; j < timelogs[i].length; j++) {
                
                int week = (startday - 1 + j) % 7 + 1;
                
                if (week == 6 || week == 7) {
                    continue;
                }
                
                if(timelogs[i][j] <= temp) {
                    continue;
                }
                
                ckeck = false;
                break;
            }
            
            if(ckeck) {
                answer++;
            }
            
        }
        
        return answer;
    }
}