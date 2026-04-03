import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int count = 0;
		for(int key : map.keySet()) {
			if(map.get(key) == 1) {
				count ++;
			}
		}
		
		System.out.println(count);
	}
}