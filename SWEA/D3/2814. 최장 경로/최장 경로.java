import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static boolean[] visited;
    static boolean[][] arr;
    static int result;
    
	public static void main(String args[]) throws Exception {
        int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
            result = 0;
			solution();
			System.out.println("#" + ts + " " + result);
		}
	}
    
    private static void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            arr[x][y] = true;
            arr[y][x] = true;
        }
        
        for(int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }
        
    }
    
    private static void dfs(int x, int count) {
        if(result < count) {
            result = count;
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[x][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
        
    }
}