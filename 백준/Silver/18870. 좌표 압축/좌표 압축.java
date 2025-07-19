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

		int[] sortArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sortArr);

		HashMap<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int i = 0; i < n; i++) {
		  if (!map.containsKey(sortArr[i])) {
		      map.put(sortArr[i], index++);
		  }
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(' ');
		}
		System.out.println(sb);
		
	}
}