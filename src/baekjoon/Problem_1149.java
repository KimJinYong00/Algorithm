package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_1149 implements Problem {

	/*
	 * 1149 RGB거리 (https://www.acmicpc.net/problem/1149)
	 */
	public static void main(String[] args) {
		Problem_1149 problem = new Problem_1149();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int[][] cost = new int[1001][3];
		int N = scan.nextInt();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				cost[i][j] = scan.nextInt();
			}
		}
		
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				
				for(int k = 0; k < 3; k++) {
					if(j == k)
						continue;
					
					if(cost[i - 1][k] <= min)
						min = cost[i - 1][k];
				}
				
				cost[i][j] = cost[i][j] + min;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(cost[N][i] <= min)
				min = cost[N][i];
		}
		
		System.out.println(min);
		
		scan.close();
	}
}
