import java.io.*;
import java.util.*;

class Main {
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		n = (1 << n);

		recursion(n, r, c);
		System.out.println(count);
	}

	private static void recursion(int size, int r, int c) {

		if (size == 1) return;

		int falf = size / 2;

		if (r < falf && c < falf) {
			recursion(falf, r, c);
		} else if (r < falf && c >= falf) {
			count += falf * falf;
			recursion(falf, r, c - falf);
		} else if (r >= falf && c < falf) {
			count += 2 * falf * falf;
			recursion(falf, r - falf, c);
		} else {
			count += 3 * falf * falf;
			recursion(falf, r - falf, c - falf);
		}
		
	}
	
}