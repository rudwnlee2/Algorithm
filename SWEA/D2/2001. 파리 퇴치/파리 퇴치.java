import java.util.*;
import java.io.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws Exception {
        int t = Integer.parseInt(br.readLine());
		
		for(int ts = 1; ts <= t; ts++) {
            int result = solution();
			System.out.println("#" + ts + " " + result);
		}
	}
    
    private static int solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = 0;
        for(int i = 0; i <n - m + 1; i++) {
            for(int j = 0; j < n - m + 1; j++) {
                int temp = 0;
                for(int k = 0; k < m; k++) {
                    for(int l = 0; l < m; l++) {
                        temp += arr[i + k][j + l];
                    }
                }
                max = Math.max(temp, max);
            }
        }
        
        return max;
    }
    
}