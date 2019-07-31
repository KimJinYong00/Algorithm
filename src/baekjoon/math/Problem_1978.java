package baekjoon.math;

import java.util.Arrays;
import java.util.Scanner;

import util.Problem;

public class Problem_1978 implements Problem {

	/*
	 * 1978 소수 찾기(https://www.acmicpc.net/problem/1978)
	 * 소수 찾기
	 */
	
	public static void main(String[] args) {
		Problem_1978 problem = new Problem_1978();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			int num = scan.nextInt();
			if(num == 1)
				continue;
			
			if(isPrimeNumber(num)) {
				count++;
			}
		}
		
		System.out.println(count);
		scan.close();
	}
	
	public boolean isPrimeNumber(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
