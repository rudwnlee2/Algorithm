import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char temp = s.charAt(0);
		int zero = 0;
		int one = 0;

		if(temp == '0') {
			zero++;
		} else {
			one++;
		}
		
		for(int i = 1; i < s.length(); i++) {
			if(temp != s.charAt(i)) {
				if(s.charAt(i) == '0') {
					zero++;
					temp = '0';
				} else {
					one++;
					temp = '1';
				}
			}
		}

		System.out.println(Math.min(zero, one));
	}
}