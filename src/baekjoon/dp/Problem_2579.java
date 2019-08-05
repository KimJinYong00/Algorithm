package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_2579 implements Problem {

	
	/*
	 * 2579 계단오르기 (https://www.acmicpc.net/problem/2579)
	 */
	public static void main(String[] args) {
		Problem_2579 problem = new Problem_2579();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] cost = new int[301];
		int[] dp =new int[301];
		
		for(int i = 1; i <= N; i++) {
			cost[i] = scan.nextInt();
		}
		
		dp[1] = cost[1];
		dp[2] = getBiggerInt(cost[2], cost[2] + cost[1]);
		dp[3] = getBiggerInt(cost[2] + cost[3], cost[1] + cost[3]);
		for(int i = 4; i <= N; i++) {
			dp[i] = getBiggerInt(dp[i - 2] + cost[i], dp[i - 3] + cost[i - 1] + cost[i]);
		}
		
		System.out.println(dp[N]);
		scan.close(); 
	}
	
	private static int getBiggerInt(int a, int b) {
		return a > b ? a : b;
	}
}
