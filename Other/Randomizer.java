package main;

import java.util.Random;
import java.util.ArrayList;

public class Randomizer {
	private Random rand = new Random();
	private ArrayList<Integer> g1 = new ArrayList<Integer>();
	
	int[] group1;
	int[] group2;
	int[] group3;
	int[] group4;
	int[] group5;
	int[] group6;

	
	public void randomGroups() {
		int number;
		do {
			number = rand.nextInt(28)+1;
			if(!g1.contains(number)) {
				g1.add(number);
			}
		}while(g1.size()<28);
	}
	
	public void printGroups(){
		for(int i=0;i<28;i++) {
			if(i<8) {
				System.out.println(g1.get(i)+" ,"+g1.get(i+1)+" ,"+g1.get(i+2)+" ,"+g1.get(i+3));
				i = i + 3;
			}else {
				System.out.println(g1.get(i)+" ,"+g1.get(i+1)+" ,"+g1.get(i+2)+" ,"+g1.get(i+3)+" ,"+g1.get(i+4));
				i = i + 4;
			}
		}
	}
	public void printGroupsSec() {
		int[] group1 = {g1.get(0),g1.get(1),g1.get(2),g1.get(3)};
		int[] group2 = {g1.get(4),g1.get(5),g1.get(6),g1.get(7)};
		int[] group3 = {g1.get(8),g1.get(9),g1.get(10),g1.get(11),g1.get(12)};
		int[] group4 = {g1.get(13),g1.get(14),g1.get(15),g1.get(16),g1.get(17)};
		int[] group5 = {g1.get(18),g1.get(19),g1.get(20),g1.get(21),g1.get(22)};
		int[] group6 = {g1.get(23),g1.get(24),g1.get(25),g1.get(26),g1.get(27)};
		
		System.out.println(group1.toString());
		System.out.println(group2.toString());
		System.out.println(group3.toString());
		System.out.println(group4.toString());
		System.out.println(group5.toString());
		System.out.println(group6.toString());
	}
}