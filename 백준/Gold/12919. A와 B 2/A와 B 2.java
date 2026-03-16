import java.io.*;
class Main {

	static int check = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		find(s, t);
		System.out.println(check);
	}

	public static void find(String s, String t) {
		if(s.length() == t.length()) {
			if(t.equals(s)) check = 1;
			return;
		}

		if(t.charAt(t.length() - 1) == 'A') {
			find(s, t.substring(0, t.length() - 1));
		}

		if(t.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder();
			for(int i = t.length()  - 1; i > 0; i--) {
				sb.append(t.charAt(i));
			}
			find(s, sb.toString());
		}
		
	}
}