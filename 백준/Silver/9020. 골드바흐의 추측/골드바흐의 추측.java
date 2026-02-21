import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[10001];
		for(int i = 2; i * i <= 10000; i++) {
			if(!arr[i]) {
				for(int j = i * i; j <= 10000; j += i) {
					arr[j] = true;
				}
			}
		}

		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			for(int j = n / 2; j >= 2; j--) {
				if(!arr[j] && !arr[n - j]) {
					sb.append(j).append(" ").append(n - j).append("\n");
					break;
				}
			}
			
		}

		System.out.println(sb);
	}
}