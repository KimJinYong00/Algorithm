package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_1260 implements Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_1260 problem = new Problem_1260();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();
		
		int[][] dot = new int[N + 1][N + 1];
		int[][] visit = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			dot[x][y] = 1;
			dot[y][x] = 1;
		}
		printMap(dot);
		System.out.print(V + " ");
		bfs(dot, visit, V);
		
		scan.close();
	}

	public void bfs(int[][] dot, int[][] visit, int start) {
		for(int i = start; i < dot.length; i++) {
			for(int j = 1; j < dot[i].length; j++) {
				if(i != j && dot[i][j] == 1 && visit[i][j] != 1) {
					visit[start][j] = 1;
					visit[j][start] = 1;
					System.out.println(j + " ");
					printMap(visit);
				}
			}
		}
	}
	
	
	public void printMap(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
