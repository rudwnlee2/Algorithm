import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);

		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = n - 1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				if(temp == arr1[mid]) {
					arr2[i] = 1;
					break;
				} else if(temp > arr1[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

			if(arr2[i] != 1) {
				arr2[i] = 0;
			}
			
		}

		for(int i : arr2) {
			System.out.println(i);
		}
		
	}
}