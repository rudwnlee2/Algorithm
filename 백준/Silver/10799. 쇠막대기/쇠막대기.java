import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int result = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			
			if(temp == '(') {
				stack.push(temp);
			} else {
				stack.pop();
				
				if(s.charAt(i - 1) == '(') {
					result += stack.size();
				} else {
					result += 1;
				}
			}
			
		}

		System.out.println(result);
	}
}