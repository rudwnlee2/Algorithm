import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int result = 0;
		for(int i = 0; i < m; i++) {
			if(s.charAt(i) == 'I') {
				int count = 0;
				int index = i;

				while(index + 2 < m) {
					if(s.charAt(index + 1) == 'O' && s.charAt(index + 2) == 'I') {
						count++;
						index += 2;

						if(count == n) {
							result++;
							count -= 1;
						}
					} else {
						break;
					}
				}

				i = index;
			}
		}
		
		System.out.println(result);
	}
}