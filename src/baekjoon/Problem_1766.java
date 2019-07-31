package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import util.Problem;

public class Problem_1766 implements Problem {

	/*
	 * 1766 문제집 (https://www.acmicpc.net/problem/1766)
	 * 
	 * 위상정렬을 이용하는 문제
	 * https://bcp0109.tistory.com/21 를 참고
	 * 
	 * 기본 Queue대신 PriorityQueue를 이용
	 */
	
	public static void main(String[] args) {
		Problem_1766 problem = new Problem_1766();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] indegree = new int[N + 1];
		
		List<Integer>[] vertex = new ArrayList[N + 1];
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		
		int M = scan.nextInt();
		
		for(int i = 1; i <= N; i++) {
			vertex[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= M; i++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			vertex[A].add(B);
			indegree[B]++;
		}
		
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				priorityQueue.add(i);
			}
		}
		
		while(!priorityQueue.isEmpty()) {
			int node = priorityQueue.poll();
			
			for(int i = 0; i < vertex[node].size(); i++) {
				int innerNode = vertex[node].get(i);
				
				indegree[innerNode]--;
				
				if(indegree[innerNode] == 0) {
					priorityQueue.add(innerNode);
				}
			}
			
			System.out.print(node + " ");
		}
		
		scan.close();
	}
}
