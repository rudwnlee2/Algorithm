import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n * n];

		int index = 0;
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
		}

		Arrays.sort(arr);

		System.out.println(arr[(n * n) - n]);
	}
}