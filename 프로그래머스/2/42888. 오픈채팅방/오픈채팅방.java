import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            
            if(arr[0].equals("Enter")) {
                list.add(new String[]{arr[1], "Enter"});
                map.put(arr[1], arr[2]);
            } else if(arr[0].equals("Leave")) {
                list.add(new String[]{arr[1], "Leave"});
            } else {
                map.replace(arr[1], arr[2]);
            }
            
        }
        
        String[] answer = new String[list.size()];
        int index = 0;
        for(String[] s : list) {
            String name = map.get(s[0]);
            
            if(s[1].equals("Enter")) {
                answer[index++] = name + "님이 들어왔습니다.";
            } else {
                answer[index++] = name + "님이 나갔습니다.";
            }
        }
        
        
        return answer;
    }
}