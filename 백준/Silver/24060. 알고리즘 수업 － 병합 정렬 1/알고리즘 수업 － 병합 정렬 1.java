import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int k;
	static int count = 0;
	static int result = -1;
	static int[] arr;
	static int[] temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		temp = new int[n];


		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(0, n - 1);
		System.out.println(result);
		
	}

	static void mergeSort(int start, int end) {
		if (count > k) {
			return;
		}

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int t = 0;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[t++] = arr[i++];
		}

		while (j <= end) {
			temp[t++] = arr[j++];
		}

		i = start;
		t = 0;

		while (i <= end) {
			count++;

			if (count == k) {
				result = temp[t];
				return;
			}

			arr[i++] = temp[t++];
		}
		
	}
	
}