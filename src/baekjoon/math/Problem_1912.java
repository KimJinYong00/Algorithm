package baekjoon.math;

import java.util.Scanner;

import util.Problem;

public class Problem_1912 implements Problem {

	/*
	 * 1912 연속합(https://www.acmicpc.net/problem/1912)
	 * 1부터 n까지 더해보면서 최대값 찾고
	 * 2부터 n까지 더해보면서 최대값이랑 비교하고
	 * 3....
	 * n까지 해보고 최대값 출력
	 */
	
	public static void main(String[] args) {
		Problem_1912 problem = new Problem_1912();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		
		int maxNum = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N;  i++) {
			int num = 0;
			for(int j = i; j <= N; j++) {
				num+=arr[j];
				
				if(num > maxNum) {
					maxNum = num;
				}
			}
		}
		
		System.out.println(maxNum);
		
		scan.close();
	}
}
