import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			String s = br.readLine();
			
			if(s.equals("end")) break;

			boolean check = false;

			int count1 = 0;
			int count2 = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
					check = true;
					count1++;
					count2 = 0;
				} else {
					count2++;
					count1 = 0;
				}

				if(count1 == 3 || count2 == 3) {
					check = false;
					break;
				}
				
				if(i > 0 && s.charAt(i) == s.charAt(i - 1)) {
					if(s.charAt(i) == 'e' || s.charAt(i) == 'o') continue;
					check = false;
					break;
				}
				
			}

			if(check) {
				sb.append("<").append(s).append("> is acceptable.\n");
			} else {
				sb.append("<").append(s).append("> is not acceptable.\n");
			}
			
		}

		System.out.println(sb);
	}
}