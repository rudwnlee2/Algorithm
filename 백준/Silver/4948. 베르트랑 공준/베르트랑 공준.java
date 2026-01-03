import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[123457 * 2];
		arr[0] = true;
		arr[1] = true;
		
		for(int i = 2; i * i < arr.length; i++) {
			if(!arr[i]) {
				for(int j = i * i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int num = 1;
		while(true) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) break;
			
			int count = 0;
			for(int i = num + 1; i <= 2 * num; i++) {
				if(!arr[i]) count++;
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}