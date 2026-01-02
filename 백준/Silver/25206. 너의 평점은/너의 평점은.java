import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double total = 0.0;
		double result = 0.0;
		
		for(int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			if(grade.equals("P")) continue;

			if(grade.equals("A+")) {
				result += score * 4.5;
			} else if(grade.equals("A0")) {
				result += score * 4.0;
			} else if(grade.equals("B+")) {
				result += score * 3.5;
			} else if(grade.equals("B0")) {
				result += score * 3.0;
			} else if(grade.equals("C+")) {
				result += score * 2.5;
			} else if(grade.equals("C0")) {
				result += score * 2.0;
			} else if(grade.equals("D+")) {
				result += score * 1.5;
			} else if(grade.equals("D0")) {
				result += score * 1.0;
			} else {
				result += score * 0.0;
			}
			total += score;
		}
		System.out.println(result / total);
	}
}