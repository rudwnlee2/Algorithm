import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int temp = 0;
		int result = 0;
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				result = Math.max(num - temp, result);
				temp = num;
			} else {
				result = Math.max((num - temp + 1) / 2, result);
				temp = num;
			}
		}

		result = Math.max(n - temp, result);
		System.out.println(result);
	}
}