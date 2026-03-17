import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = Integer.parseInt(br.readLine());
		for(int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			
			int temp = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(temp == 1) {
				for(int j = num; j <= n; j += num) {
					if(arr[j] == 1) {
						arr[j] = 0;
					} else {
						arr[j] = 1;
					}
				}
			} else {
				int count = 0;
				while(true) {
					if(num - count <= 0 || num + count > n) break;
					
					if(arr[num - count] == arr[num + count]) {
						if(arr[num - count] == 1) {
							arr[num - count] = 0;
							arr[num + count] = 0;
						} else {
							arr[num - count] = 1;
							arr[num + count] = 1;
						}
						count++;
					} else {
						break;
					}
				}
			}
			
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}