import java.util.*;
import java.io.*;

class Solution {
    
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
		for(int ts = 1; ts <= 10; ts++) {
			result = 0;
            solution();
            System.out.println("#" + ts + " " + result);
		}
	}
    
    private static void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 100; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        for(int i = 0; i <n; i++) {
            arr[99] -= 1;
            arr[0] += 1;
            Arrays.sort(arr);
        }
        
        result = arr[99] - arr[0];
    }
}