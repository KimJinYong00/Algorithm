package baekjoon.dp;

import java.util.Scanner;

import util.Problem;

public class Problem_10844 implements Problem {

	/*
	 * 10844 쉬운 계단 수 (https://www.acmicpc.net/problem/10844)
	 */
	public static void main(String[] args) {
		
		Problem_10844 problem = new Problem_10844();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] dp = new int[101][11];
		
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 11; j++)
				dp[i][j] = 0;
		}
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1];
			for(int j = 1; j < 10; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			result = (result + dp[N][i]) % 1000000000;
		}
		
		System.out.println(result );
		
		scan.close();
	}

	

}
