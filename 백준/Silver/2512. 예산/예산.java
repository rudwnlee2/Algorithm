import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		int m = Integer.parseInt(br.readLine());

		int result = 0;
		if(sum <= m) {
			for(int i = 0; i < n; i++) {
				result = Math.max(result, arr[i]);
			}
		} else {
			Arrays.sort(arr);
			int count = n;
			for(int i = 0; i < n; i++) {
				if(arr[i] * count < m) {
					m -= arr[i];
					count--;
					continue;
				}

				result = m / count;
				break;
			}
		}
		
		System.out.println(result);
	}
}