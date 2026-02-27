import java.io.*;
class Main {
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(!arr[index].equals("KBS1")) {
			sb.append("1");
			index++;
		}

		while(index > 0) {
			swap(index, index - 1);
			index--;
			sb.append("4");
		}

		while(!arr[index].equals("KBS2")) {
			sb.append("1");
			index++;
		}

		while(index > 1) {
			swap(index, index - 1);
			index--;
			sb.append("4");
		}
		
		System.out.println(sb);
	}

	public static void swap(int a, int b) {
		String temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}