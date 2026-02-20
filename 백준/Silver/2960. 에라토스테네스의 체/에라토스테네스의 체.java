import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[n + 1];

		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(!arr[i]) {
				for(int j = i; j <= n; j += i) {
					if(!arr[j]) {
						arr[j] = true;
						count++;
						if(count == k) {
							System.out.println(j);
							return;
						}
					}
				}
			}
		}
		
	}
}