import java.io.*;

class Solution
{
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static int answer;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
		
            int n = Integer.parseInt(br.readLine());
            col = new boolean[n];
            diag1 = new boolean[2 * n];
            diag2 = new boolean[2 * n];
            
            answer = 0;
            dfs(0, n);
            
            System.out.println("#" + tc + " " + answer);

		}
	}
    
    static void dfs(int x, int n) {
        
        if(x == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            
            if (col[i] || diag1[x + i] || diag2[x - i + n]) continue;
            
            col[i] = true;
            diag1[x + i] = true;
            diag2[x - i + n] = true;
            
            dfs(x + 1, n);
            
            col[i] = false;
            diag1[x + i] = false;
            diag2[x - i + n] = false;
        }
        
    }
        
}