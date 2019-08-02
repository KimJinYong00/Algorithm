package baekjoon.bruteforce;

import java.util.Scanner;

import util.Problem;

public class Problem_2798 implements Problem {
	
	/*
	 * 2798 블랙잭 (https://www.acmicpc.net/problem/11279)
	 * 삼중for 돌면서 모든 최대값을 계산한다.
	 */
	
	public static void main(String[] args) {
		Problem_2798 problem = new Problem_2798();
		
		problem.solve();
	}

	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] card = new int[N + 1][2];
		
		for(int i = 1; i <= N; i++) {
			card[i][0] = scan.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			int max = 0;
			int first = card[i][0];
			int secondSum;
			int thirdSum;
			
			if(first >= M)
				continue;
			
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					continue;
				}
				
				secondSum = card[j][0] + first;
				
				if(secondSum <= M) {
					for(int k = 1; k <= N; k++) {
						if(k == i || k == j) {
							continue;
						}
						
						thirdSum = card[k][0] + secondSum;
						
						if(thirdSum >= max && thirdSum <= M) {
							card[i][1] = thirdSum;
							max = thirdSum;
						}
					}
				}
			}	
		}
		
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			if(card[i][1] >= max) {
				max = card[i][1];
			}
		}
		
		System.out.println(max);
		scan.close();
	}
}
