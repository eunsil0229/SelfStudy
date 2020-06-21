package com.selfStud.practice;

import java.util.Scanner;

public class Conference {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[][] times = new int[n][2];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<2; j++) {
				times[i][j] = scanner.nextInt();
			}
		}
		
		
		
	}
}
