import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {

		for(int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            int result = solution();
			System.out.println("#" + tc + " " + result);
		}
	}
    
    
    static int solution() throws Exception {
        int[][] arr = new int[100][100];
        StringTokenizer st;
        int cy = 0;
        int cx = 0;
        
        for (int i = 0; i < 100; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    cy = i;
                    cx = j;
                }
            }
        }

		int way = 3;
		while (cy > 0) { 
			if (cx - 1 >= 0 && arr[cy][cx - 1] == 1 && way != 2) {
				cx--;
				way = 1;
			} else if (cx + 1 < 100 && arr[cy][cx + 1] == 1 && way != 1) {
				cx++;
				way = 2;
			} else {
				cy--;
				way = 3;
			}
		}

	return cx;
	}
}