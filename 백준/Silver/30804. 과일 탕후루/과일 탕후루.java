import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int left = 0;

		Map<Integer, Integer> map = new HashMap<>();
		
		for(int right = 0; right < n; right++) {
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

			while(map.size() > 2) {
				map.put(arr[left], map.get(arr[left]) - 1);
				
				if(map.get(arr[left]) == 0) {
					map.remove(arr[left]);
				}
				
				left++;
			}
			
			int count = right - left + 1;
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
}