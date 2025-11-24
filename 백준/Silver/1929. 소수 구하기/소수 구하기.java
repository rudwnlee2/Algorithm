import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[m + 1];
		arr[0] = true;
		arr[1] = true;

		for(int i = 2; i <= Math.sqrt(m); i++) {
			if(arr[i] == true) continue;

			for(int j = i * i; j < arr.length; j = j + i) {
				arr[j] = true;
			}
		}

		for(int i = n; i <= m; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
	}
}