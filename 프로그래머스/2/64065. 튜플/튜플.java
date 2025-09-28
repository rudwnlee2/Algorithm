import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answerList = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");
        
        String[] temp = s.split("-");
        
        Arrays.sort(temp,new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
            
        });
        
        for(String group : temp) {
            String[] arr = group.split(",");
            
            for(int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                
                if (!answerList.contains(num)) {
                    answerList.add(num);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
         
        return answer;
    }
}