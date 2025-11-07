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
        int result = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    count += 1;
                } else {
                    if(count == k) {
                        result += 1;
                    }
                    count = 0;
                }
            }
            if(count == k) {
                result += 1;
            }
        }
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[j][i] == 1) {
                    count += 1;
                } else {
                    if(count == k) {
                        result += 1;
                    }
                    count = 0;
                }
            }
            if(count == k) {
                result += 1;
            }
        }
        
        return result;
    }
}