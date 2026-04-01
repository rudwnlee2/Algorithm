import java.io.*;
import java.util.*;

class Main {

	static int n;

	static String[] operator;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			operator = new String[n - 1];

			find(1);
			
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void find(int num) {
		if(num == n) {
			if(check()) {
				sb.append(1);
				
				int temp = 2;
				for(int i = 0; i < operator.length; i++) {
					sb.append(operator[i]).append(temp);
					temp++;
				}

				sb.append("\n");
			}

			return;
		}

		operator[num - 1] = " ";
		find(num + 1);

		operator[num - 1] = "+";
		find(num + 1);

		operator[num - 1] = "-";
		find(num + 1);
		
	}

	private static boolean check() {
		if(cacul() == 0) {
			return true;
		}

		return false;
	}

	private static int cacul() {
		int result = 0;
		int sign = 1;
		int tempNum = 1;

		int num = 2;
		for(int i = 0; i < operator.length; i++) {
			if(operator[i].equals("+")) {
				result += (sign * tempNum);
				tempNum = num;
				sign = 1;
			} else if(operator[i].equals("-")) {
				result += (sign * tempNum);
				tempNum = num;
				sign = -1;
			} else {
				tempNum = (tempNum * 10) + num;
			}

			num++;
		}
		result += (sign * tempNum);

		return result;
	}
	
}