import java.io.*;
import java.util.*;

class Main {

	static int[][][] arr = new int[21][21][21];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int a;
		int b;
		int c;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if(a == -1 && b == -1 && c == -1) break;
			
			int temp = w(a, b, c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(temp).append("\n");
		}

		System.out.println(sb);
	}

	private static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) return 1;
		if (a > 20 || b > 20 || c > 20)  return w(20, 20, 20);

		if (arr[a][b][c] != 0) return arr[a][b][c];

		if (a < b && b < c) {
			arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		} else {
			arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}

		return arr[a][b][c];
	}
}