import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++) {
            String temp = String.valueOf(i);
            
            if (temp.contains("3") || temp.contains("6") || temp.contains("9")) {
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
                        System.out.print("-");
                    }
                    
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
            
        }
        
	}
}