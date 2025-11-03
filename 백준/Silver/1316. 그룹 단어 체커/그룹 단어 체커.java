import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];

		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		int count = 0;
		for(int i = 0; i < n; i++) {
			List<Character> list = new ArrayList<>();
			char[] temp = arr[i].toCharArray();
			boolean check = true;
			list.add(temp[0]);
			
			for(int j = 1; j < temp.length; j++) {
				if(temp[j - 1] == temp[j]) continue;
				if(list.contains(temp[j])) { 
					check = false;
					break;
				}
				
				list.add(temp[j]);
			}

			if(check) {
					count++;
			}
		}

		System.out.println(count);
		
	}
}