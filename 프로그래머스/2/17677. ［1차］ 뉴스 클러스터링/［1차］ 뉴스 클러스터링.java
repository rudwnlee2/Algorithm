import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 1;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String temp = "";
            temp += str1.charAt(i);
            temp += str1.charAt(i + 1);
            
            if(Character.isLetter(temp.charAt(0)) && Character.isLetter(temp.charAt(1))) {
                a.add(temp);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String temp = "";
            temp += str2.charAt(i);
            temp += str2.charAt(i + 1);
            
            if(Character.isLetter(temp.charAt(0)) && Character.isLetter(temp.charAt(1))) {
                b.add(temp);
            }
        }
        
        int sum = a.size() + b.size();
        
        int count = 0;
        for(String s : a) {
            if(b.contains(s)) {
                count++;
                b.remove(s);
            }
        }
        
        if(sum - count == 0) {
            answer = 65536;
        } else {
            double result = (double) count / (sum - count);
            answer = (int) (result * 65536);
        }
        
        return answer;
    }
}