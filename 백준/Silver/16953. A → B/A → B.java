import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int count = 1;
		while(b > a) {
			if(b % 2 == 0) {
				b /= 2;
			} else if(b % 10 == 1) {
				b /= 10;
			} else {
				break;
			}
			count++;
		}

		if(b == a) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
		
	}
}