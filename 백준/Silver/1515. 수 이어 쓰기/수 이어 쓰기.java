import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();

		int index = 0;
		int num = 0;
		
		while(index < arr.length) {
			num += 1;
			String temp = Integer.toString(num);

			for(int i = 0; i < temp.length(); i++) {
				if(temp.charAt(i) == arr[index]) index += 1;

				if(index >= arr.length) {
					System.out.println(num);
					return;
				}
			}
			
		}
		
	}
}