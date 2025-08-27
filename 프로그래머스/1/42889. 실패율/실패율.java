import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        List<double[]> list = new ArrayList<>();
        
        int index = stages.length;
        for(int i = 1; i <= N; i++) {
            int count = 0;
            for(int j = 0; j < stages.length; j++) {
                if(stages[j] == i) {
                    count++;
                }
            }
            
            if (index == 0) {
                list.add(new double[]{i, 0});
                index -= count;
                continue;
            }
            
            list.add(new double[]{i, (double) count / index});
            index -= count;
        }
        
        list.sort((a, b) -> {
            int cmp = Double.compare(b[1], a[1]);
            if (cmp == 0) {
                return Double.compare(a[0], b[0]);
            }
            return cmp;
        });
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = (int)list.get(i)[0];
        }
        
        return answer;
    }
}