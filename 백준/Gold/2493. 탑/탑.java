import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {1, Integer.parseInt(st.nextToken())});
		sb.append("0 ");

		for(int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= num) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				} else {
					stack.pop();
				}
			}

			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i + 1, num});
		}

		System.out.println(sb);
	}
}