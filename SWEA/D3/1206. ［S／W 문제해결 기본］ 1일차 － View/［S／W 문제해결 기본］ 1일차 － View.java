import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
		for(int tc = 1; tc <= 10; tc++) {
            int result = solution();
			System.out.println("#" + tc + " " + result);
		}
	}
    
    static int solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int total = 0;
        for(int i = 2; i < n - 2; i++) {
            int left = Math.max(arr[i - 1], arr[i - 2]);
            int rifgt = Math.max(arr[i + 1], arr[i + 2]);
            int max = Math.max(left, rifgt);
            
            if(arr[i] > max) total += arr[i] - max;
        }
        
        return total;
  
    }
}