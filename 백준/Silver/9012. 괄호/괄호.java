import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();

			for(int j = 0; j < s.length(); j++) {
				char temp = s.charAt(j);
				if(temp == '(') {
					stack.push(temp);
				} else if(stack.isEmpty()) {
					stack.push(temp);
					break;
				} else {
					stack.pop();
				}
			}

			if(stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
		
	}
}