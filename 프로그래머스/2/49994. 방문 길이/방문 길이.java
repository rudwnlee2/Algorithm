import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        char[] arr = dirs.toCharArray();
        HashSet<String> visited = new HashSet<>();
        int y = 0;
        int x = 0;
        
        for(int i = 0; i < arr.length; i++) {
            
            int ny = y;
            int nx = x;
            
            if (arr[i] == 'U') ny++;
            else if (arr[i] == 'D') ny--;
            else if (arr[i] == 'R') nx++;
            else if (arr[i] == 'L') nx--;
            
            if (ny < -5 || ny > 5 || nx < -5 || nx > 5) continue;
            
            String path1 = y + "," + x + "," + ny + "," + nx;
            String path2 = ny + "," + nx + "," + y + "," + x;
            
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            
            y = ny;
            x = nx;
        }
        
        return answer;
    }
}