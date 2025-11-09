import java.util.*;

class Solution {
    
    private static int answer = 0;
    private static Set<Integer> set = new HashSet<>();
    private static boolean[] prime;
    private static boolean[] visited;
    
    public int solution(String numbers) {
        
        Character[] arr = new Character[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        
        int num = Integer.parseInt(sb.toString());
        
        prime = new boolean[num + 1];
        prime[0] = true;
        prime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(prime[i]) continue;
            
            for(int j = i * i; j <= num; j = j + i) {
                prime[j] = true;
            }
        }
        
        visited = new boolean[numbers.length()];
        dfs("", numbers);
        
        for(int n : set) {
            if(!prime[n]) answer++;
        }
        
        return answer;
    }
    
    private static void dfs(String num, String numbers) {
        
        for(int i = 0; i < numbers.length(); i++) {
            
            if(visited[i] == false) {
                visited[i] = true;
                
                String newNum = num + numbers.charAt(i);
                set.add(Integer.parseInt(newNum));
                
                dfs(newNum, numbers);
                visited[i] = false;
            }
        }
    }
    
}