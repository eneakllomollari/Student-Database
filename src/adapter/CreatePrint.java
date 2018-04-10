package adapter;

import util.*;
import model.*;
import java.util.*;

public abstract class CreatePrint implements GBCons {

	private Util u;
	private Statistics s = new Statistics();
	private InstructorReport arr3 = null;
	private Hashtable<Integer, Student> sHashTable = new Hashtable<Integer, Student>();
	private Hashtable<Integer, StudentReport> reportHT = new Hashtable<Integer, StudentReport>();

	public void createGradeBook(String fname) {

		// This method must be called first - before printGradeBook() or getStats() or
		// printStudentScores()
		// we will call existing methods to:

		// a. read the file and build a student array - call readFile in Util
		u = new Util(fname, 40);
		u.readFile(sHashTable); // assigns the student array

		// b. compute statistics. - call methods in Statistics
		s.analyze(sHashTable);

		// c. build StudentReport array [done in lab 6]
		Enumeration<Student> e = sHashTable.elements();
		while (e.hasMoreElements()) {
			Student stude = e.nextElement();
			StudentReport sR = new StudentReport(stude, s);
			reportHT.put(stude.getId(), sR);
		}
		// d. serialize student report - up to 40 files. [done in lab 6]
		Enumeration<StudentReport> eNum = reportHT.elements();
		while (eNum.hasMoreElements()) {
			StudentReport sRep = eNum.nextElement();
			u.writeStudentReportToDisk(sRep, sRep.getStudent().getId() + ".ser");
		}
		// e. For instructor - write one file (serialized) with Student [] and
		// Statistics
		arr3 = new InstructorReport(sHashTable, s);
		u.writeInstructorReporttodisk(arr3, "InstructorReport");
	}

	public void printGradeBook() {
		if (DEBUG) {
			System.out.println("\n\t\t\t\t\t\t\t\tGRADE BOOK");
			InstructorReport s = u.readfromdiskforInstructor("InstructorReport");
			if (s != null)
				s.print();
		}
	}

	public void getStats() {
		if (DEBUG) {
			StudentReport s = u.readFromDiskforStudent("1666.ser");
			s.getStats().print();
		}
	}

	public void printstudentscores(int id) {
		if (DEBUG) {
			StudentReport s = u.readFromDiskforStudent(id + ".ser");
			if (s != null)
				s.print();
			else
				System.out.println("\n\n\n\t\t\t\t\t\t*** The student id you provided does not exist! ***");
		}
	}

	public void printGrades(int id) {
		if (DEBUG) {
			StudentReport s = u.readFromDiskforStudent(id + ".ser");
			if (s != null)
				System.out.printf("\n\n\t\t\t\t\t\tID:  %d  |   Grade:  %s", id, s.getStudent().getGrade());
			else
				System.out.printf("\t\t\t\t\t\t*** The student id you provided does not exist! ***");
		}

	}
}