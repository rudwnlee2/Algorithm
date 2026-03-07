import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		StringBuilder sb = new StringBuilder();
		sb.append("I");

		for(int i = 0; i < n; i++) {
			sb.append("OI");
		}

		int count = 0;
		for(int i = 0; i <= m - sb.length(); i++) {
			if(s.charAt(i) == 'I') {
				boolean check = true;
				
				for(int j = 0; j < sb.length(); j++) {
					if(s.charAt(i + j) != sb.charAt(j)) {
						check = false;
						break;
					}
				}

				if(check) count++;
			}
		}
		
		System.out.println(count);
	}
}