import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] arr = new String[t];

		for(int i = 0; i < t; i++) {
			arr[i] = br.readLine();
		}

		String[] result = new String[t];
		for(int i = 0; i < t; i++) {
			result[i] = nextPermutatation(arr[i]);
		}

		for(String s : result) {
			System.out.println(s);
		}
		
	}

	static String nextPermutatation(String word) {
		char[] temp = word.toCharArray();
		int n = temp.length;
		int index = 0;

		for(int i = n - 1; i > 0; i--) {
			if(temp[i - 1] < temp[i]) {
				index = i;
				break;
			}
		}

		if(index == 0) return word;
		
		for(int i = n - 1; i >= index; i--) {
			if(temp[index - 1] < temp[i]) {
				char swap = temp[index - 1];
				temp[index - 1] = temp[i];
				temp[i] = swap;
				break;
			}
		}

		Arrays.sort(temp, index, n);

		return new String(temp);

	}
	
}