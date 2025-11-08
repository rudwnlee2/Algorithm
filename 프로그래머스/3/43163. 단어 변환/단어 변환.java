import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[] {begin, "0"});
        
        while(!queue.isEmpty()) {
            String[] temp = queue.poll();
            String word = temp[0];
            
            if(target.equals(word)) {
                return Integer.parseInt(temp[1]);
            }
            
            int count = Integer.parseInt(temp[1]);
            
            for (int i = 0; i < word.length(); i++) {
                char[] charWord = word.toCharArray();
                
                for (char c = 'a'; c <= 'z'; c++) {
                    if (charWord[i] == c) {
                        continue; 
                    }

                    charWord[i] = c;
                    String nextWord = new String(charWord);
                    
                    for (int j = 0; j < words.length; j++) {                    
                        if (words[j].equals(nextWord) && !visited[j]) {
                            queue.offer(new String[] {nextWord, String.valueOf(count + 1)});
                            visited[j] = true;
                            
                            break; 
                        }
                    }
                }
            }
            
        }
        
        return answer;
    }
}