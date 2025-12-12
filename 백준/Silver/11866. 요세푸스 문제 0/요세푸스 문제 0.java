import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}

		int index = 0;
		System.out.print("<");
		while(list.size() > 1) {
			index = (index + (k - 1)) % list.size();
			System.out.print(list.remove(index) + ", ");
		}
		System.out.print(list.remove(0));
		System.out.print(">");
	}
}