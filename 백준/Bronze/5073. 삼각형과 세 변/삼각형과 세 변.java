import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while(true) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());

			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

			Arrays.sort(arr);

			if(arr[2] >= arr[0] + arr[1]) {
				sb.append("Invalid\n");
			} else if(arr[0] == arr[1] && arr[1] == arr[2]) {
				sb.append("Equilateral\n");
			} else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[2] == arr[1]) {
				sb.append("Isosceles\n");
			} else {
				sb.append("Scalene\n");
			}
			
		}
		
		System.out.println(sb);
	}
}