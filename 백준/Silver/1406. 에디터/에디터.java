import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			left.push(s.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			char c = temp.charAt(0);

			if(c == 'L') {
				if(!left.isEmpty()) right.push(left.pop());
			} else if(c == 'D') {
				if(!right.isEmpty()) left.push(right.pop());
			} else if(c == 'B') {
				if(!left.isEmpty()) left.pop();
			} else {
				left.push(temp.charAt(2));
			}
			
		}

		while(!right.isEmpty()) {
			left.push(right.pop());
		}

		StringBuilder sb = new StringBuilder();
		for(char c : left) {
			sb.append(c);
		}

		System.out.println(sb);
	}
}