import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int[] arr = new int[10];

		for(int i = 0; i < n.length(); i++) {
			int temp = n.charAt(i) - '0';
			if(temp == 6) {
				arr[9] += 1;
			} else {
				arr[temp] += 1;
			}
		}

		int max = 0;
		for(int i = 0; i < 9; i++) {
			max = Math.max(max, arr[i]);
		}

		if (arr[9] % 2== 1) {
			arr[9] = (arr[9] / 2) + 1;
		} else {
			arr[9] = arr[9] / 2;
		}

		max = Math.max(max, arr[9]);
		System.out.print(max);
	}
}