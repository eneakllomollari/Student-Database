package model;

import java.io.Serializable;

public class StudentReport implements Serializable {
	private Student student;
	private Statistics stats;

	public StudentReport(Student student, Statistics stats) {
		this.student = student;
		this.stats = stats;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public String toString() {
		return "StudentReport [student=" + student + ", stats=" + stats + "]";
	}

	public void print() {
		this.student.print();
		this.stats.print();
	}
}