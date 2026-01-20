import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			int score = 0;

			int count = 1;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'O') {
					score += count;
					count++;
				} else {
					count = 1;
				}
			}

			sb.append(score).append("\n");
		}

		System.out.println(sb);
	}
}