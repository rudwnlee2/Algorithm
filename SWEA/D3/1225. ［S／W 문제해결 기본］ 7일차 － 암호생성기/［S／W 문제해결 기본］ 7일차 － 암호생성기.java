import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception {
		for(int ts = 1; ts <= 10; ts++) {
			br.readLine();
			System.out.print("#" + ts + " ");
			solution();		
			System.out.println();
		}
	}
    
    private static void solution() throws Exception {    	
    	int[] arr = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < 8; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        
        int value = 1;
        while(true) {
        	int num = q.poll();
        	
        	num -= value;
        	
        	if(num <= 0) {
        		num = 0;
        		q.offer(num);
        		break;
        	}
        	
        	q.offer(num);
        	
        	value++;
        	if(value > 5) {
                value = 1;
            }
        }
        
        for(int num : q) {
            System.out.print(num + " ");
        }
    }
}