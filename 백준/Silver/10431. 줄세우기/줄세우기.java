import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int testNum = Integer.parseInt(st.nextToken());
			sb.append(testNum).append(" ");
			int[] arr = new int[20];

			for(int j = 0; j < 20; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for(int j = 0; j < 20; j++) {
				for(int k = 0; k < j; k++) {
					if(arr[k] > arr[j]) count++;
				}
			}

			sb.append(count).append("\n");
		}



		
		System.out.println(sb);
	}
}