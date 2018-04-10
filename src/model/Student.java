package model;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
	private int id;
	private int scores[] = new int[5];
	private String grade;

	public Student() {
	}

	public Student(int id, int[] scores) {
		this.id = id;
		this.scores = scores;
		this.calcGrade(); // calculate the grades at time of construction
	}

	public void setId(int val) {
		this.id = val;
	}

	public void setScores(int val, int i) {
		this.scores[i] = val;
	}

	public int getId() {
		return id;
	}

	public int[] getScores() {
		return scores;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void calcGrade() {
		float acc = 0;
		for (int i : scores)
			acc += i;
		float ave = acc / scores.length;
		this.grade = this.getGradeFromScore(ave);
	}

	private String getGradeFromScore(float f) {
		if (f >= 97)
			return "A+";
		else if (f >= 93)
			return "A";
		else if (f >= 90)
			return "A-";
		else if (f >= 87)
			return "B+";
		else if (f >= 83)
			return "B";
		else if (f >= 80)
			return "B-";
		else if (f >= 77)
			return "C+";
		else if (f >= 73)
			return "C";
		else if (f >= 70)
			return "D+";
		else if (f >= 63)
			return "D";
		else if (f >= 60)
			return "D-";
		else
			return "F";

	}

	public String toString() {
		return "[id=" + id + ", scores=" + Arrays.toString(scores) + "]";
	}

	public void print() {
		System.out.printf("\n\t\t\t\t\t\tID: %d | Scores:  %d  %d  %d  %d  %d  |  Grade  %s", this.id, this.scores[0],
				this.scores[1], this.scores[2], this.scores[3], this.scores[4], this.grade);
	}
}
