import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("all")) {
				set.clear();
				for (int k = 1; k <= 20; k++) {
					set.add(k);
				}
			} else if (command.equals("empty")) {
				set.clear();
			} else {
				int num = Integer.parseInt(st.nextToken());

				if (command.equals("add")) {
					set.add(num);
				} else if (command.equals("remove")) {
					set.remove(num);
				} else if (command.equals("check")) {
					if (set.contains(num)) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
				} else if (command.equals("toggle")) {
					if (set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}
				}
			}
		}
		System.out.print(sb);
	}
}