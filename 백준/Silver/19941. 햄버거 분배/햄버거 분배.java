import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		char[] arr = new char[n];
		boolean[] check = new boolean[n];
		
		String s = br.readLine();
		for(int i = 0; i < n; i++) {
			arr[i] = s.charAt(i);
			if(arr[i] == 'H') check[i] = true;
		}

		int index = 0;
		int count = 0;
		while(index < n) {
			if(arr[index] == 'H') {
				index++;
				continue;
			}
			
			boolean next = false;
			
			for(int i = k; i > 0; i--) {
				if(index - i < 0) continue;

				if(check[index - i]) {
					check[index - i] = false;
					next = true;
					count++;
					break;
				}
			}

			if(next) {
				index++;
				continue;
			}

			for(int i = 0; i <= k; i++) {
				if(index + i >= n) continue;

				if(check[index + i]) {
					check[index + i] = false;
					count++;
					break;
				}
			}
			
			index++;
		}
		
		System.out.println(count);
	}
}