import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int[] player1;
    static int[] player2;
    static boolean[] visited;
    static int win;
    static int lose;
    
	public static void main(String args[]) throws Exception {
        int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
			solution();
			System.out.println("#" + ts + " " + win + " " + lose);
		}
	}
    
    private static void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        player1 = new int[9];
        player2 = new int[9];
        boolean[] check = new boolean[19];
        
        for(int i = 0; i < 9; i++) {
            player1[i] = Integer.parseInt(st.nextToken());
            check[player1[i]] = true;
        }
        
        int temp = 0;
        for(int i = 1; i <= 18; i++) {
            if(!check[i]) {
                player2[temp] = i;
                temp++;
            }
        }
        
        visited = new boolean[9];
        win = 0;
        lose = 0;
        
        dfs(0, 0, 0);
    }
    
    private static void dfs(int round, int p1, int p2) {
        if(round == 9) {
            if(p1 > p2) {
                win++;
            } else if(p1 < p2) {
                lose++;
            }
            return;
        }
        
        for(int i = 0; i < 9; i++) {
            if(visited[i]) continue;
            
            int p1Card = player1[round];
            int p2Card = player2[i];
            
            int score = p1Card + p2Card;
            
            visited[i] = true;
            if(p1Card > p2Card) {
                dfs(round + 1, p1 + score, p2);
            } else {
                dfs(round + 1, p1, p2 + score);
            }
            
            visited[i] = false;
        }
    }
}