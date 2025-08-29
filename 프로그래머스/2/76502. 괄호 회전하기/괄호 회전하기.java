import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            Stack<Character> stack = new Stack<>();
            
            for(int j = i; j < i + arr.length; j++) {
                if(stack.isEmpty()) {
                    stack.push(arr[j % arr.length]);
                    continue;
                }
                
                char temp = stack.peek();
                
                if(temp == '(' && arr[j % arr.length] == ')') stack.pop();
                else if(temp == '{' && arr[j % arr.length] == '}') stack.pop();
                else if(temp == '[' && arr[j % arr.length] == ']') stack.pop();
                else stack.push(arr[j % arr.length]);
            }
            
            if(stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}