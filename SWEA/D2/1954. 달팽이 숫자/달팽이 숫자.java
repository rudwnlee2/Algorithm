import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
        
        int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
			int[][] result = solution();
			System.out.println("#" + ts);
            for(int[] temp : result) {
                for(int num : temp) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
		}
	}
    
    private static int[][] solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        
        int[] dy = { 0, 1, 0, -1 }; 
		int[] dx = { 1, 0, -1, 0 };
		int y = 0;
		int x = 0;
        
        int dir = 0;
        int num = 1;
        
        while(num <= n * n) {
            arr[y][x] = num;
            
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            if(ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            
            y = ny;
            x = nx;
            num += 1;
        }
        
        return arr;
    }
    
}