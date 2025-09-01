import java.util.*;

class Solution {
     public int[] solution(int[] progresses, int[] speeds) {

            List<Integer> list = new ArrayList<>();
            int[] arr = new int[progresses.length];
            
            for(int i = 0; i < progresses.length; i++) {
                if ((100 - progresses[i]) % speeds[i] == 0) {
                    arr[i] = (100 - progresses[i]) / speeds[i];
                } else {
                    arr[i] = (100 - progresses[i]) / speeds[i] + 1;
                }
            }

            int temp = arr[0];
            int count = 1;

            for(int i = 1; i < progresses.length; i++) {

                if(temp < arr[i]) {
                    list.add(count);
                    temp = arr[i];
                    count = 1;
                } else {
                    count++;
                }
            }

            list.add(count);

            int[] answer = new int[list.size()];

            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
}