package baekjoon.bruteforce;

import java.util.Scanner;

import util.Problem;

public class Problem_2231 implements Problem {
	
	/*
	 * 2231 분해합 (https://www.acmicpc.net/problem/11279)
	 * N이하의 모든수의 분해합을 계산해서 배열에 넣고 답찾기
	 */
	
	public static void main(String[] args) {
		Problem_2231 problem = new Problem_2231();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			int digit = getDigitLength(i);
			int sum = i;
			
			for(int j = 1; j <= digit; j++) {
				sum += getTargetDigitNum(i, j);
			}
			
			arr[i] = sum;
		}
		
		int result = 0;
		for(int i = 1; i < N; i++) {
			if(arr[i] == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		scan.close();
	}
	
	public int getDigitLength(int number) {
		String numStr = String.valueOf(number);
		
		int result = numStr.length();
		
		if(number < 0)
			return result - 1;
		
		return numStr.length();
	}
	
	public int getTargetDigitNum(int number, int targetDigit) {
		if(targetDigit < 1)
			return -1;
		
		int result = -1;
		
		for(int i = 0; i < targetDigit; i++) {
			result = number % 10;
			
			number /= 10;
		}
		
		return result;
	}
}
