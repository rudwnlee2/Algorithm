import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] arr;
    static int result;
    
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};

    static Set<String> set;
    
	public static void main(String args[]) throws Exception {

        int t = Integer.parseInt(br.readLine());
        
		for(int ts = 1; ts <= t; ts++) {
            result = 0;
			solution();
            result = set.size();
            System.out.println("#" +  ts + " " + result);
		}
        
	}
    
    static void solution() throws Exception {
        arr = new String[4][4];
        StringTokenizer st;
        set = new HashSet<>();
        
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = st.nextToken();
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dfs(i, j, 0, arr[i][j]);
            }
        }
        result = set.size();
    }
    
    static void dfs(int y, int x, int count, String currentNum) {
        if (count == 6) {
            set.add(currentNum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int ny = y + my[i];
            int nx = x + mx[i];
            
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            
            dfs(ny, nx, count + 1, currentNum + arr[ny][nx]);
            
        }
    }
}