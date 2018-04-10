package model;

import java.io.Serializable;
import java.util.*;

public class InstructorReport implements Serializable {
	private Hashtable<Integer, Student> stu;
	private Statistics stats;

	public InstructorReport(Hashtable<Integer, Student> stu, Statistics stats) {
		this.stu = stu;
		this.stats = stats;
	}

	public Hashtable<Integer, Student> getStu() {
		return stu;
	}

	public void setStu(Hashtable<Integer, Student> stu) {
		this.stu = stu;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public void print() {
		Enumeration<Integer> e = stu.keys();
		while (e.hasMoreElements()) {
			stu.get(e.nextElement()).print();
		}
	}
}