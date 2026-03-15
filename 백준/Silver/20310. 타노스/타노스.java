import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int one = 0;
		int zero = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') {
				zero++;
			} else {
				one++;
			}
		}

		one /= 2;
		zero /= 2;

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1' && one > 0) {
				one--;
				continue;
			}

			sb.append(s.charAt(i));
		}

		for(int i = sb.length() - 1; i >= 0; i--) {
			if(sb.charAt(i) == '0' && zero > 0) {
				sb.deleteCharAt(i);
				zero--;
			}

			if(zero == 0) break;
		}

		System.out.println(sb);
	}
}