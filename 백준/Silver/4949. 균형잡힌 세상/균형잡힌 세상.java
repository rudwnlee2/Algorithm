import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();

			int len = s.length();
			if (s.equals(".")) break;
			
			boolean check = false;
			for (int i = 0; i < len; i++) {
				if (s.charAt(i) == '(') {
					stack.push('(');
				} else if (s.charAt(i) == '[') {
					stack.push('[');
				} else if (s.charAt(i) == ')') {
					if (stack.isEmpty()) {
						System.out.println("no");
						check = true;
						break;
					} else if (stack.peek() == '(') {
						stack.pop();
					} else {
						System.out.println("no");
						check = true;
						break;
					}
				} else if (s.charAt(i) == ']'){
					if (stack.isEmpty()) {
						System.out.println("no");
						check = true;
						break;
					} else if (stack.peek() == '[') {
						stack.pop();
					} else {
						System.out.println("no");
						check = true;
						break;
					}
				} else {
					continue;
				}
				
			}

			if (!check) {
				if (stack.isEmpty()) {
	        System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
			
		}
		
	}
}