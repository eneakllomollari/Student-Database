package model;

import java.util.*;
import java.io.*;

public class Statistics implements Serializable {
	private int lowscores[] = new int[5];
	private int highscores[] = new int[5];
	private float avgscores[] = new float[5];

	public void analyze(Hashtable<Integer, Student> stuHT) {
		this.findavg(stuHT);
		this.findhigh(stuHT);
		this.findlow(stuHT);
	}

	private void findhigh(Hashtable<Integer, Student> stuHT) {
		int min;
		for (int i = 0; i < 5; i++) {
			min = 100;
			Enumeration<Integer> e = stuHT.keys();
			while (e.hasMoreElements()) {
				Student s = stuHT.get(e.nextElement());
				if (s.getScores()[i] < min)
					min = s.getScores()[i];
			}
			highscores[i] = min;
		}
	}

	private void findlow(Hashtable<Integer, Student> stuHT) {
		int max;
		for (int i = 0; i < 5; i++) {
			max = 0;
			Enumeration<Integer> e = stuHT.keys();
			while (e.hasMoreElements()) {
				Student s = stuHT.get(e.nextElement());
				if (s.getScores()[i] > max)
					max = s.getScores()[i];
			}
			highscores[i] = max;
		}
	}

	private void findavg(Hashtable<Integer, Student> stuHT) {
		float acc;
		int numStudents;

		Enumeration<Integer> allKeys = stuHT.keys();
		while (allKeys.hasMoreElements()) {
			acc = 0.0f;
			numStudents = 0;
			Student s = stuHT.get(allKeys.nextElement());
			for (int j = 0; j < 5; j++) {
				if (s != null) {
					acc += s.getScores()[j];
				}
				if (s != null)
					numStudents++;
				avgscores[j] = acc / numStudents;
			}
		}
	}

	public void print() {
		System.out.printf("\n\n\t\t\t\t\t\t\t        ***  Statistics  ***\n");
		System.out.println("\t\t\t\t\t\t+-------+------------+---------------+---------------+");
		System.out.printf("\t\t\t\t\t\t|Quiz # |Lowest Score|Highest Score  |Average Score  |\n");
		for (int i = 0; i < lowscores.length; i++)
			System.out.printf("\t\t\t\t\t\t|  %d    |    %d\t     |    %d\t     |    %2.2f\t     |\n", i + 1,
					lowscores[i], highscores[i], avgscores[i]);
		System.out.println("\t\t\t\t\t\t+-------+------------+---------------+---------------+");
	}

	public String toString() {
		return "[lowscores= " + Arrays.toString(lowscores) + ", \nhighscores= " + Arrays.toString(highscores)
				+ ", \navgscores=" + Arrays.toString(avgscores) + "]";
	}
}