import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();

		Set<String> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		int result = 0;
		if(game.equals("Y")) {
			result = set.size();
		} else if(game.equals("F")) {
			result = set.size() / 2;
		} else {
			result = set.size() / 3;
		}
		
		System.out.println(result);
	}
}