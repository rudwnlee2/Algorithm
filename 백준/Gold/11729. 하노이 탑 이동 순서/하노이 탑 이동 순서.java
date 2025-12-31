import java.io.*;
class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		sb.append((int) (Math.pow(2, n) - 1)).append('\n');
		hanoi(n, 1, 2, 3);
		System.out.println(sb);
	}

	public static void hanoi(int n, int start, int mid, int to) {
		if(n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}

		hanoi(n - 1, start, to, mid);
		sb.append(start + " " + to + "\n");
		hanoi(n - 1, mid, start, to);
	}
}