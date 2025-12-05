import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			String[] temp = s.split(" ");
			String command = temp[0];

			if(command.equals("push")) {
				int num = Integer.parseInt(temp[1]);
				q.offer(num);
			} else if(command.equals("pop")) {
				if(q.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(q.poll());
				}
			} else if(command.equals("size")) {
				System.out.println(q.size());
			} else if(command.equals("empty")) {
				if(q.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if(command.equals("front")) {
				if(q.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(q.peek());
				}
			} else if(command.equals("back")) {
				if(q.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(q.peekLast());
				}
			}
		}
		
	}
}