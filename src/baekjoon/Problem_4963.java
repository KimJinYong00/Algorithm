package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_4963 implements Problem {

	
	/*
	 * 4963 섬 개수 (https://www.acmicpc.net/problem/4963)
	 */
	public static void main(String[] args) {
		Problem_4963 problem = new Problem_4963();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			
			if(N == 0 || M == 0)
				break;
			
			int[][] map = new int[M][N];
			int[][] visit = new int[M][N];
			int cnt = 0;
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
					visit[i][j] = 0;
				}
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1 && visit[i][j] != 1) {
						visit[i][j] = 1;
						bfs(map, visit, i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
		scan.close();
	}
	
	public void bfs(int[][] map, int[][] visit, int x, int y) {
		for(int j = y - 1; j <= y + 1; j++) {
			if(j < 0 || j >= map[0].length)
				continue;
			for(int i = x - 1; i <= x + 1; i++) {
				if(i < 0 || i >= map.length)
					continue;
				
				if(map[i][j] == 1 && visit[i][j] != 1) {
					visit[i][j] = 1;
					bfs(map, visit, i, j);
				}
			}
		}
	}
}
