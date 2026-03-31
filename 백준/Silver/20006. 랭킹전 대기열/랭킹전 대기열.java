import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<String[]>[] arr = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			arr[i] = new ArrayList<String[]>();
		}

		int index = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			for(int j = 0; j <= index; j++) {
				if(arr[j].isEmpty()) {
					arr[j].add(new String[] {name, String.valueOf(num)});
					index++;
					break;
				}

				if(arr[j].size() >= m) continue;

				String[] temp = arr[j].get(0);
				int x = Integer.parseInt(temp[1]);
				
				if(x >= num - 10 && x <= num + 10) {
					arr[j].add(new String[] {name, String.valueOf(num)});
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < index; i++) {

			if(arr[i].size() == m) {
				sb.append("Started!\n");
			} else {
				sb.append("Waiting!\n");
			}

			ArrayList<String> list = new ArrayList<>();
			for(String[] s : arr[i]) {
				list.add(s[0]);
			}

			Collections.sort(list);

			for(int j = 0; j < list.size(); j++) {
				for(int k = 0; k < arr[i].size(); k++) {
					String[] c = arr[i].get(k);
					if(list.get(j).equals(c[0])) {
						sb.append(c[1]).append(" ").append(c[0]).append("\n");
						break;
					}
				}
			}
			
		}
		
		System.out.println(sb);
	}
}