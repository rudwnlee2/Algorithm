import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<>(Collections.reverseOrder());

		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String temp = st.nextToken();

			set.add(name);
			if(temp.equals("leave")) set.remove(name);
		}
		
		for(String s : set) {
			System.out.println(s);
		}
		
	}
}