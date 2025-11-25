import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long max = 0;
		long min = 1;
		int[] arr = new int[k];
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) max = arr[i];
		}
		
		long result = 0;
		while(min <= max) {

			long mid = (min + max) / 2;
			
			int count = 0;
			for(int i = 0; i < k; i++) {
				count += arr[i] / mid;
			}

			if(count >= n) {
				result = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
			
		}

		System.out.println(result);
	}
}