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
        
        int[][] sumArr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        }
        
        int max = 0;
        for(int i = 0; i <= n - m; i++) {
            for(int j = 0; j <= n - m; j++) {
                int temp = sumArr[i + m][j + m] - sumArr[i][j + m] - sumArr[i + m][j] + sumArr[i][j];
                max = Math.max(max, temp);
            }
        }
        
        return max;
    }
    
}