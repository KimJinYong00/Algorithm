package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_2193 implements Problem {

	
	/*
	 * 2193 이친수 (https://www.acmicpc.net/problem/2193)
	 */
	public static void main(String[] args) {
		Problem_2193 problem = new Problem_2193();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long[][] dp = new long[91][2];
		
		dp[0][0] = 0;
		dp[0][1] = 1;
		
		for(int i = 1; i <= N; i++) {
			if(i == N) {
				dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
			}
			else {
				dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
				dp[i][1] = dp[i - 1][0];
			}
		}
		
		System.out.println(dp[N][1]);
		scan.close();
	}
}
