import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int result;
    static boolean[][] arr;
    static boolean[] visited;
    static int n;
    
	public static void main(String args[]) throws Exception {
		for(int ts = 1; ts <= 10; ts++) {
            result = 0;
			solution();
			System.out.println("#" + ts + " " + result);
		}
	}
    
    private static void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new boolean[100][100];
        visited = new boolean[100];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            arr[x][y] = true;
        }
        
        dfs(0);
    }
    
    private static void dfs(int index) {
        if(index == 99) {
            result = 1;
            return;
        }
        
        visited[index] = true;
        for(int i = 0; i < 100; i++) {
            if(arr[index][i] && !visited[i]) {
                dfs(i);
            }
        }
            
    }
}