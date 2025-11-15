import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        int[][] arr = new int[9][9];
        StringTokenizer st;
        
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Set<Integer> check = new HashSet<>();
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                check.clear();
                for(int y = i; y < i + 3; y++) {
                    for(int x = j; x < j + 3; x++) {
                        check.add(arr[y][x]);
                    }
                }
                if(check.size() != 9) {
                    return;
                }
            }
        }
        
        Set<Integer> y = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            y.clear();
            x.clear();
            for(int j = 0; j < 9; j++) {
                y.add(arr[j][i]);
                x.add(arr[i][j]);
            }
            if(y.size() != 9 || x.size() != 9) {
                return;
            }
        }
        
        result = 1;
    }
}