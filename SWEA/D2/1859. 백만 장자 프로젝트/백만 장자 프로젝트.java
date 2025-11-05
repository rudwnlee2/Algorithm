import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
		
        int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
			long result = solution();
			System.out.println("#" + ts + " " + result);
		}
	}
    
    private static long solution() throws Exception {
        long count = 0;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(max < arr[i]) {
                max = arr[i];
            } else {
                count += max - arr[i];
            }
        }
        
        return count;
    }
}