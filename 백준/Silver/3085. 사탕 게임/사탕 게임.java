import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];

		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}

		int result = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j + 1 < n) {
					swap(arr, i, j, i, j + 1);
					result = Math.max(result, checkMax(arr, n));
					swap(arr, i, j, i, j + 1);   
				}

				if(i + 1 < n) {
					swap(arr, i, j, i + 1, j);
					result = Math.max(result, checkMax(arr, n));
					swap(arr, i, j, i + 1, j);
				}
			}
		}

		System.out.println(result);
		
	}

	public static int checkMax(char[][] arr, int n) {
		int max = 1;

		for(int i = 0; i < n; i++) {
			int count = 1;
			for(int j = 1; j < n; j++) {
				if(arr[i][j] == arr[i][j - 1]) {
					count++;
				} else {
					count = 1;
				}
				max = Math.max(max, count);
			}
		}

		for(int i = 0; i < n; i++) {
			int count = 1;
			for(int j = 1; j < n; j++) {
				if(arr[j][i] == arr[j-1][i]) {
					count++;
				} else {
					count = 1;
				}
				max = Math.max(max, count);
			}
		}

		return max;
		
	}

	public static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
		char temp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = temp;
	}
}