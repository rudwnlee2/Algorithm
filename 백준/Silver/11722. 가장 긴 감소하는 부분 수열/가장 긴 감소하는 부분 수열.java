import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] temp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int len = 0;
		for(int x : arr) {
			int pos = Arrays.binarySearch(temp, 0, len, -x);

			if (pos < 0) pos = -(pos + 1);

			temp[pos] = -x;
			
			if (pos == len) len++;
		}

		System.out.println(len);
	}
}