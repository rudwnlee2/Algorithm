import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for(int i = 4; i < 101; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(arr[num]).append("\n");
		}
		
		System.out.println(sb);
	}
}