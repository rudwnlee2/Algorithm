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

		int[] arr2 = new int[n];
		int index = 0;
		
		for(int i = 0; i < n; i++) {
			if(index == 0 || arr1[i] > arr2[index - 1]) {
				arr2[index] = arr1[i];
				index += 1;
			} else{
				int pos = Arrays.binarySearch(arr2, 0, index, arr1[i]);
				if (pos < 0) {
					pos = -(pos + 1);
				}
				arr2[pos] = arr1[i];
			}

		}

		System.out.println(index);
		
	}
}