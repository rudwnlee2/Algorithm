import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int count = 0;
		int max = 0;
		for(int i = 0; i < x; i++) {
			sum += arr[i];
		}

		if(sum > 0) {
			count++;
			max = sum;
		}

		int index = 0;
		for(int i = x - 1; i < n - 1; i++) {
			sum -= arr[index++];
			sum += arr[i + 1];
			if(sum > 0) {
				if(max < sum) {
					count = 1;
					max = sum;
				} else if(max == sum) {
					count++;
				}
			}
		}

		//시간 초과
		// for(int i = 0; i <= n - x; i++) {
		// 	int sum = 0;
		// 	for(int j = i; j < i + x; j++) {
		// 		sum += arr[j];
		// 	}
		// 	if(sum > 0) {
		// 		if(max < sum) {
		// 			count = 1;
		// 			max = sum;
		// 		} else if(max == sum) {
		// 			count++;
		// 		}
		// 	}
		// }

		if(count == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
		
	}
}