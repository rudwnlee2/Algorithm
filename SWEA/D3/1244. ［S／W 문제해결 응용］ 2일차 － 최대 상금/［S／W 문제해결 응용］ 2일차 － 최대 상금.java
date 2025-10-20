import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static char arr[];
    static int n;
    static String result;
    
	public static void main(String args[]) throws Exception {
        
        int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
            answer = solutuion();
			System.out.println("#" + test_case + " " + answer);
		}
	}
    
    static int solutuion() throws Exception {
        
        StringTokenizer st =new StringTokenizer(br.readLine());
        String s = st.nextToken();
        n = Integer.parseInt(st.nextToken());
        arr = s.toCharArray();
        result = "";
        
        dfs(0, 0);
        
        return Integer.parseInt(result);
    }
    
    static void dfs(int depth, int count) {
        
        if(count == n){
            String current = new String(arr); 
            if (current.compareTo(result) > 0) {  
                result = current;  
            }
            return;
       }
        
        for(int i = depth; i < arr.length - 1; i++) {
           for(int j = i + 1; j < arr.length; j++) {
               change(i, j);
               dfs(i, count + 1);
               change(i, j);
           }
       }
        
    }
    
    static void change(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}