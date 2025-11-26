import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long max = 0;
		long min = 0;
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
		}

		long result = 0;
		while(min <= max) {
			long mid = (max + min) / 2;

			long sum = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i] - mid > 0) {
					sum += arr[i] - mid;
				}
			}

			if(sum > m) {
				min = mid + 1;
				result = mid;
			} else if(sum < m) {
				max = mid - 1;
			} else {
				result = mid;
				break;
			}
			
		}
		
		System.out.println(result);
	}
}