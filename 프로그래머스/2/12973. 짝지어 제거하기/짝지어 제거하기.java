import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            
            if(stack.peek() == arr[i]) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
            
        }
        
        if(stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}