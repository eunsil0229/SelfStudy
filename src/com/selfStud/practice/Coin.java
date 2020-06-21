package com.selfStud.practice;

import java.util.Scanner;

public class Coin {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = scanner.nextInt();
		}
		
	
		
		//int i;
		int sum=0;
		
		/*
		while(true) {
			for(i=0; i<n; i++) {
				if(coins[i] > k) {
					break;
				}
			}
			
			int num = k/coins[i-1];
			k = k-(num*coins[i-1]);
			sum += num;
			
			if(k == 0) {
				System.out.println(sum);
				break;
			}
			
		}
		*/
		
		for(int i=n-1; i>=0 && k>=0; i--) {
			if(coins[i] <= k) {
				int num = k/coins[i];
				k = k-(num*coins[i]);
				sum += num;
			}
			
		}
		
		System.out.println(sum);
	
		
		
		
	}

}
