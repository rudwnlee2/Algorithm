import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
        
        int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
            int tsNum = Integer.parseInt(br.readLine());
            int result = solution();
			System.out.println("#" + tsNum + " " + result);
		}
	}
    
    private static int solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 1000; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        
        int maxNum = 0;
        int maxCount = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currentNum = entry.getKey();
            int currentCount = entry.getValue();
            
            if(maxCount < currentCount) {
                maxNum = currentNum;
                maxCount = currentCount;
            } else if(maxCount == currentCount) {
                maxNum = Math.max(maxNum, currentNum);
            }
        }
        return maxNum;
    }
}