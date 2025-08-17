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
		Arrays.sort(arr);

		int left = 0;
		int right = n - 1;
		int min = Integer.MAX_VALUE;

		int[] result = new int[2];

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				result[0] = arr[left];
				result[1] = arr[right];
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.print(result[0] + " " + result[1]);
		
	}
}