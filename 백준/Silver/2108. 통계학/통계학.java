import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			map.put(temp, map.getOrDefault(temp, 0) + 1);
			arr[i] = temp;
			sum += temp;
		}

		Arrays.sort(arr);
		
		int max = 0;
		for(int i : map.values()) {
			max = Math.max(max, i);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key) == max){
				list.add(key);
			} 
		}
		Collections.sort(list);
		
		System.out.println((int) Math.round((double) sum / n));
		System.out.println(arr[n / 2]);
		if(list.size() == 1) {
			System.out.println(list.get(0));
		} else {
			System.out.println(list.get(1));
		}
		System.out.println(arr[n - 1] - arr[0]);
	}
}