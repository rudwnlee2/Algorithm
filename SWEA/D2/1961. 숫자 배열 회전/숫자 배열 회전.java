import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr90;
    static int[][] arr180;
    static int[][] arr270;
    
	public static void main(String args[]) throws Exception {
		int t = Integer.parseInt(br.readLine());

		for(int ts= 1; ts <= t; ts++) {
            solution();
            System.out.println("#" + ts);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < n; j++) {
                    System.out.print(arr180[i][j]);
                }
                System.out.print(" ");

				for (int j = 0; j < n; j++) {
                    System.out.print(arr270[i][j]);
                }
                System.out.println();

            }
        }
	}
    
    private static void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        arr90 = rotation(arr);
        arr180 = rotation(arr90);
        arr270 = rotation(arr180);
    }
    
    private static int[][] rotation(int[][] arr) {
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