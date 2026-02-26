import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String kNum = Integer.toString(n, k);
        int answer = 0;
        
        boolean[] check = new boolean[1000001];
        
        
        String[] arr = kNum.split("0");
        for(String s : arr) {
            if(s.equals("")) continue;
            
            long num = Long.parseLong(s);
            
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(Long num) {
        if(num == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}