import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String temp = br.readLine();

			Deque<Integer> deque = new LinkedList<>();
			String inner = temp.substring(1, temp.length() - 1);
			if (!inner.isEmpty()) {
				String[] tmpeArr = inner.split(",");
				for (String s : tmpeArr) {
					deque.add(Integer.parseInt(s));
				}
			}

			boolean isRight = true;
			boolean isError = false;
			
			for (char c : p.toCharArray()) {
				if(c == 'R') {
					isRight = !isRight;
				} else {
					if(deque.isEmpty()) {
						isError = true;
						break;
					}

					if(isRight) {
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
				}
			}

			if(isError) {
				sb.append("error\n");
			} else {
				sb.append("[");
				if(!deque.isEmpty()) {
					if(isRight) {
						sb.append(deque.pollFirst());
						while (!deque.isEmpty()) {
							sb.append(",").append(deque.pollFirst());
						}
					} else {
						sb.append(deque.pollLast());
						while (!deque.isEmpty()) {
							sb.append(",").append(deque.pollLast());
						}
					}
				}
				sb.append("]\n");
			}
		}

		System.out.println(sb);
	}
}