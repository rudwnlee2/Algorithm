import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());


		int start = 1;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if(num >= start) {
				while(start <= num) {
					stack.push(start);
					sb.append("+\n");
					start++;
				}
			}

			if(!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
			
		}


		System.out.println(sb);
	}
}