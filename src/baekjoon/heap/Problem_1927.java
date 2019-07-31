package baekjoon.heap;

import java.util.Scanner;

import util.Problem;

public class Problem_1927 implements Problem {

	/*
	 * 1927 최소 힙 (https://www.acmicpc.net/problem/1927)
	 */
	
	public static void main(String[] args) {
		Problem_1927 problem = new Problem_1927();
		
		problem.solve();
	}
	
	int HEAP_IDX = 0;
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] heap = new int[100001];
		
		for(int i = 0; i < N; i++) {
			int x = scan.nextInt();
			
			if(x == 0) {
				System.out.println(pop(heap));
			}
			else {
				push(heap, x);
//				print(heap);
			}
		}
		
		
		scan.close();
	}
	
	public void push(int[] heap, int value) {
		heap[++HEAP_IDX] = value;
		
		int i = HEAP_IDX;
		while(i > 0) {
			if(i / 2 < 1) {
				break;
			}
			
			if(heap[i / 2] > heap[i]) {
				int temp = heap[i];
				
				heap[i] = heap[i / 2];
				heap[i / 2] = temp;
				i = i / 2;
			}
			else {
				break;
			}
		}
	}
	
	public int pop(int[] heap) {
		if(HEAP_IDX == 0)
			return HEAP_IDX;
		
		int result = heap[1];
		
		heap[1] = heap[HEAP_IDX--];
		
		int i = 1;
		
		while(i < HEAP_IDX) {
			int leftChildIdx = i * 2;
			int rightChildIdx = i * 2 + 1;
			int minIdx;
			if(leftChildIdx > HEAP_IDX) {
				break;
			}
			
			if(rightChildIdx > HEAP_IDX) {
				minIdx = leftChildIdx;
			}
			else {
				if(heap[leftChildIdx] > heap[rightChildIdx]) {
					minIdx = rightChildIdx;
				}
				else {
					minIdx = leftChildIdx;
				}
			}
			
			if(heap[i] > heap[minIdx]) {
				int temp = heap[i];
				
				heap[i] = heap[minIdx];
				heap[minIdx] = temp;
				i = minIdx;
			}
			else {
				break;
			}
		}
		
		return result;
	}
	
	public void print(int[] heap) {
		for(int i = 1; i <= HEAP_IDX; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}
