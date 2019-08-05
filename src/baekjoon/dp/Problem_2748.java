package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

import util.Problem;

public class Problem_2748 implements Problem {
	
	/*
	 * 2748 피보나치 수 2 (https://www.acmicpc.net/problem/11279)
	 * 
	 */
	
	public static void main(String[] args) {
		Problem_2748 problem = new Problem_2748();
		
		problem.solve();
	}

	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		long[] fibo = new long[90];
		Arrays.fill(fibo, -1);
		fibo[0] = 0;
		fibo[1] = 1;
		
		int N = scan.nextInt();
		
		for(int i = 2; i < N; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		System.out.println(fibo[N - 1]);
		
		scan.close();
	}
	
	public void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "");
		}
		System.out.println();
	}
}
