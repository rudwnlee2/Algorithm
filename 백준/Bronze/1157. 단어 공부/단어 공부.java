import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toUpperCase();

		int[] arr = new int[26];
		for(int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i) - 'A';
			arr[temp] += 1;
		}

		int max = 0;
		char answer = '?';
		for(int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				answer = (char)(i + 'A');
			} else if(max == arr[i]) {
				answer = '?';
			}
		}

		System.out.println(answer);		
	}
}