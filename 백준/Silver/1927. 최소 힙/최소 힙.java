import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int count = 0;
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				if(heap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(heap.poll());
				}
			} else {
				heap.add(temp);
			}
		}
		
	}
}