package com.selfStud.practice;

import java.util.Scanner;

public class Atm {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		int[] minutes = new int[num];
		
		for(int i=0; i<num; i++) {
			minutes[i] = scanner.nextInt();
		}
		
		
		int temp;
		for(int i=0; i<num; i++) {
			for(int j=0; j<i; j++) {
				if(minutes[i]<minutes[j]) {
					temp = minutes[i];
					minutes[i] = minutes[j];
					minutes[j] = temp;
				}
			}
		}
		
	
		int sum = 0;
		int sum2 = 0;
		
		for(int minute : minutes) {
			sum += minute;
			sum2 += sum;
		}
		
		System.out.println(sum2);
		
		
		
		
		
	}

}
