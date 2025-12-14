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

		
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());

			int start = 0;
			int end = n - 1;
			boolean c = false;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				if(num == arr[mid]) {
					System.out.print(1 + " ");
					c = true;
					break;
				} else if(num > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			if(!c) System.out.print(0 + " ");
		}
		
	}
}