package baekjoon.bruteforce;

import java.util.Scanner;

import util.Problem;

public class Problem_7568 implements Problem {
	
	/*
	 * 7568 덩치 (https://www.acmicpc.net/problem/11279)
	 * i번째 덩치와 나머지를 모두 비교해서 count세기
	 */
	
	public static void main(String[] args) {
		Problem_7568 problem = new Problem_7568();
		
		problem.solve();
	}

	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[][] weight = new int[N + 1][2];
		
		int[] resultArr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			weight[i][0] = scan.nextInt();
			weight[i][1] = scan.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			int rank = 0;
			
			for(int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				
				if(isBigger(weight[i], weight[j])) {
					rank++;
				}
			}
			
			resultArr[i] = rank + 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(i > 1)
				System.out.print(" ");
			System.out.print(resultArr[i]);
		}
		
		scan.close();
	}
	
	public boolean isBigger(int[] A, int[] B) {
		
		if(B[0] > A[0]) {
			if(B[1] > A[1]) {
				return true;
			}
		}
		
		return false;
	}
}
