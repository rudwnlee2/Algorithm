import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] name = new String[n];
		int[] score = new int[n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			score[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int temp = Integer.parseInt(br.readLine());

			boolean check = false;
			int left = 0;
			int right = n - 1;
			int mid = 0;
			int before = 0;
			while(left <= right) {
				mid = (right + left) / 2;

				if(score[mid] >= temp) {
					right = mid - 1;
					check = true;
					before = mid;
				} else {
					left = mid + 1;
				}

			}

			// 시간초과
			// for(int j = 0; j < n; j++) {
			// 	if(score[j] >= temp) {
			// 		check = true;
			// 		sb.append(name[j]).append("\n");
			// 		break;
			// 	}
			// }

			if(!check) {
				sb.append(name[n - 1]).append("\n");
			} else {
				sb.append(name[before]).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
}