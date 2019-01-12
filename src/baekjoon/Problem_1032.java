package baekjoon;

import util.Problem;

public class Problem_1032 implements Problem {
	
	/*
	 * 1032 명령프롬프트 (https://www.acmicpc.net/problem/1032)
	 */
	
	public static void main(String[] args) {
		Problem_1032 problem = new Problem_1032();
		
		problem.solve();
		
	}

	@Override
	public void solve() {
		int N = scanner.nextInt();
		String[] strArr = new String[N];
		
		String pattern = "";
		
		for(int i = 0; i < N; i++) {
			strArr[i] = scanner.next();
			
			if(i == 0)
				pattern = strArr[i];
			else
				pattern = compareString(pattern, strArr[i]);
		}
		
		System.out.println(pattern);
	}
	
	public String compareString(String str1, String str2) {
		String result = "";
		
		for(int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			
			if(c1 == c2)
				result += c1;
			else
				result += "?";
		}
		
		return result;
	}
}
