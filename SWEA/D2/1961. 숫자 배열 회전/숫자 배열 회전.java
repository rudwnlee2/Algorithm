import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
			int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
			
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
			int[][] arr90 = change(arr);
			int[][] arr180 = change(arr90);
			int[][] arr270 = change(arr180);
			
			System.out.println("#" + ts);
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				
				for(int j = 0; j < n; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				
				for(int j = 0; j < n; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
	}
    
    private static int[][] change(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = arr[n - 1 - j][i];
            }
        }
        
        return result;
    }
}