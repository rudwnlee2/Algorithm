import java.util.*;

class Solution {
    
    List<String> list = new ArrayList<>();
    boolean[] visited;
    boolean check = false;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        list.add("ICN");
        dfs(0, "ICN", tickets);
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private void dfs(int depth, String start, String[][] tickets) {
        if(depth == tickets.length) {
            check = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                list.add(tickets[i][1]);
                dfs(depth + 1, tickets[i][1], tickets);
                
                if(check) return;
                
                visited[i] = false;
                // list.remove(tickets[i][1]); // 맨 마지막 원소를 제거 하는게 아니라 앞에서 부터 확인해서 삭제
                list.remove(list.size() - 1);
            }
        }
        
    }
}

// class Solution {
    
//     List<String> list = new ArrayList<>();
//     boolean[] visited;
    
//     public String[] solution(String[][] tickets) {
//         visited = new boolean[tickets.length];
        
//         Arrays.sort(tickets, (a, b) -> {
//             if (a[0].equals(b[0])) {
//                 return a[1].compareTo(b[1]);
//             }
//             return a[0].compareTo(b[0]);
//         });
        
//         list.add("ICN");
//         dfs(0, "ICN", tickets);
        
//         String[] answer = new String[list.size()];
//         for(int i = 0; i < answer.length; i++) {
//             answer[i] = list.get(i);
//         }
        
//         return answer;
//     }
    
//     private void dfs(int depth, String start, String[][] tickets) {
//         if(depth == tickets.length) {
//             return;
//         }
        
//         for(int i = 0; i < tickets.length; i++) {
//             if(!visited[i] && start.equals(tickets[i][0])) {
//                 visited[i] = true;
//                 list.add(tickets[i][1]);
//                 dfs(depth + 1, tickets[i][1], tickets);
//             }
//         }
        
//     }
// }