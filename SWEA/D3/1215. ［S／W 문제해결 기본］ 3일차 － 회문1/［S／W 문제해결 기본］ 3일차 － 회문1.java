import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
		int t = 10;
        
		for(int ts = 1; ts <= t; ts++) {
			int result = solution();
			System.out.println("#" + ts + " " + result);
		}
	}
    
    private static int solution() throws Exception {
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        
        char[][] arr = new char[8][8];
        for(int i = 0; i < 8; i++) {
            String temp = br.readLine();
            for(int j = 0; j < 8; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j <= 8 - n; j++) {
                boolean check = true;
                for(int k = 0; k < n / 2; k++) {
                    if(arr[i][j + k] != arr[i][j + n - 1 - k]) {
                        check = false;
                        break;
                    }
                }
                if(check) result++;
            }
        }
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j <= 8 - n; j++) {
                boolean check = true;
                for(int k = 0; k < n / 2; k++) {
                    if(arr[j + k][i] != arr[j + n - 1 - k][i]) {
                        check = false;
                        break;
                    }
                }
                if(check) result++;
            }
        }
        
        return result;
    }
}