import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result;
    
	public static void main(String args[]) throws Exception {
		int t = Integer.parseInt(br.readLine());
        
		for (int tc = 1; tc <= t; tc++) {
			result = 0;
            solution();
			System.out.println("#" + tc + " " + result);
		}
        
	}
    
    static void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j]=temp.charAt(j) - '0';
            }
        }
        
        int start = n / 2;
        int end = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = start; j <= end; j++) {
                result += arr[i][j];
            }
            
            if (i < n / 2) {
                start -= 1;
                end += 1;
            } else {
                start += 1;
                end -= 1;
            }
        }
        
    }
}