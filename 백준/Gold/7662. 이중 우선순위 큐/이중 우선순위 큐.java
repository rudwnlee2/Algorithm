import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++) {
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			Map<Integer, Integer> map = new HashMap<>();

			int n = Integer.parseInt(br.readLine());

			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if(s.equals("I")) {
					maxQ.offer(num);
					minQ.offer(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if(num == 1) {
						while(!maxQ.isEmpty() && map.getOrDefault(maxQ.peek(), 0) == 0) {
							maxQ.poll();
						}
						if(maxQ.isEmpty()) continue;
						int temp = maxQ.poll();
						map.put(temp, map.get(temp) - 1);
						if(map.get(temp) == 0) {
							map.remove(temp);
						}
					} else {
						while(!minQ.isEmpty() && map.getOrDefault(minQ.peek(), 0) == 0) {
							minQ.poll();
						}
						if(minQ.isEmpty()) continue;
						int temp = minQ.poll();
						map.put(temp, map.get(temp) - 1);
						if(map.get(temp) == 0) {
							map.remove(temp);
						}
					}
				}
				
			}

			while(!maxQ.isEmpty() && map.getOrDefault(maxQ.peek(), 0) == 0) {
				maxQ.poll();
			}

			while(!minQ.isEmpty() && map.getOrDefault(minQ.peek(), 0) == 0) {
				minQ.poll();
			}

			if(map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(maxQ.peek()).append(" ").append(minQ.peek()).append("\n");
			}
			
		}

		System.out.println(sb);
	}
}