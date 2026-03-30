import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> temp = map.getOrDefault(num, new ArrayList<>());
				temp.add(num);
				
				map.put(num, temp);
				arr[j] = num;
			}

			List<Integer> list = new ArrayList<>();
			for(int key : map.keySet()) {
				if(map.get(key).size() >= 6) list.add(key);
			}

			int rank = 1;
			Map<Integer, List<Integer>> team = new HashMap<>();
			for(int j = 0; j < n; j++) {
				int temp = arr[j];
				
				if(list.contains(temp)) {
					List<Integer> ranks = team.getOrDefault(temp, new ArrayList<>());
					
					ranks.add(rank);
					team.put(temp, ranks);
					
					rank++;
				}
			}

			list.sort((a, b) -> {
				List<Integer> rankA = team.get(a);
		        List<Integer> rankB = team.get(b);

				int sumA = rankA.get(0) + rankA.get(1) + rankA.get(2) + rankA.get(3);
		        int sumB = rankB.get(0) + rankB.get(1) + rankB.get(2) + rankB.get(3);

				if(sumA == sumB) {
	                return Integer.compare(rankA.get(4), rankB.get(4));
		        }

				return Integer.compare(sumA, sumB);
			});
			
			sb.append(list.get(0)).append("\n");
		}
		
		System.out.println(sb);
	}
}