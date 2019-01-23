package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_11726 implements Problem {
	
	/*
	 * 2xn 타일링 (https://www.acmicpc.net/problem/11726)
	 */
	public static void main(String[] args) {
		Problem_11726 problem = new Problem_11726();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		//dp[3] = 3, dp[4] = 5 dp[5] = 8
		
		for(int i = 3; i < 1001; i ++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[N]);
		scan.close();
	}

}
