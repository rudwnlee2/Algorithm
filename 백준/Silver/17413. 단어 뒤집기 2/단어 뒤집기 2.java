import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				sb.append(s.charAt(i));
				i++;
				while(s.charAt(i) != '>') {
					sb.append(s.charAt(i));
					i++;
				}
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			} else {
				stack.add(s.charAt(i));
			}
		}

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}