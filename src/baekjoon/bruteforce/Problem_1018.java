package baekjoon.bruteforce;

import java.util.Scanner;

import util.Problem;

public class Problem_1018 implements Problem {
	
	/*
	 * 1018 체스판 다시 칠하기 (https://www.acmicpc.net/problem/11279)
	 * 인덱스 하나씩 옮겨가면서 몇개 색칠해야하는지 카운트 후 최소값 찾기
	 */
	
	public static void main(String[] args) {
		Problem_1018 problem = new Problem_1018();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		String[][] map = new String[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = scan.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = String.valueOf(input.charAt(j));
			}
		}
		
		int minCount = Integer.MAX_VALUE;
		
		int count = minCount;
		
		for(int i = map.length - 1; i >= 0; i--) {
			for(int j = map[i].length - 1; j >= 0; j--) {
				if(j - 7 >= 0 && i - 7 >= 0) {
					count = getCountOfPainting(map, j, i);
					
					if(minCount > count)
						minCount = count;
				}
			}
		}
		
		System.out.println(minCount);
		scan.close();
	}
	
	public int getCountOfPainting(String[][] map, int x, int y) {
		String[] colorArr = {"W", "B"};
		int[] count = new int[2];
		
		for(int k = 0; k < colorArr.length; k++) {
			int colorIdx = k;
			
			for(int i = y; i >= y - 7; i--) {
				for(int j = x; j >= x - 7; j--) {
					if(!colorArr[colorIdx].equals(map[i][j])) {
						count[k]++;
					}
					
					colorIdx = (colorIdx + 1) % 2;
				}
				
				colorIdx = (colorIdx + 1) % 2;
			}
		}
		
		if(count[0] > count[1])
			return count[1];
		else
			return count[0];
	}
	
	public void print(String[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
}
