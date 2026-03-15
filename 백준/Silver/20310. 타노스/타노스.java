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
		for(int i = 0; i < zero; i++) sb.append("0");
		for(int i = 0; i < one; i++) sb.append("1");

		System.out.println(sb);
	}
}