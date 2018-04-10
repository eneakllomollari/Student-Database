package util;

import java.io.*;
import java.util.*;
import model.*;

public class Util {
	private String fileName;

	public Util(String fileName, int num) {
		this.fileName = fileName;
	}

	public Util() {
	}

	public void setPath(String fname) {
		this.fileName = fname;
	}

	public void writeStudentReportToDisk(StudentReport a1, String fname) {
		try {
			FileOutputStream outFile = new FileOutputStream(fname);
			ObjectOutputStream outStream = new ObjectOutputStream(outFile);
			outStream.writeObject(a1);
			outStream.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}

	public void writeInstructorReporttodisk(InstructorReport a1, String fname) {
		try {
			FileOutputStream p = new FileOutputStream(fname);
			ObjectOutputStream p1 = new ObjectOutputStream(p);
			p1.writeObject(a1);
			p1.close();
		} catch (Exception e) {
			// exception message
		}
	}

	public StudentReport readFromDiskforStudent(String fname) {
		StudentReport a = null;
		try {
			FileInputStream file = new FileInputStream(fname);
			ObjectInputStream inStream = new ObjectInputStream(file);
			a = (StudentReport) inStream.readObject();
			inStream.close();
		} catch (Exception e) {
			// System.out.println("Error -- " + e.toString());
		}
		return a;
	}

	public InstructorReport readfromdiskforInstructor(String fname) {
		InstructorReport a = null;
		try {
			FileInputStream p = new FileInputStream(fname);
			ObjectInputStream p1 = new ObjectInputStream(p);
			a = (InstructorReport) p1.readObject();
			p1.close();
		} catch (Exception e) {
			// exception message
		}
		return a;
	}

	public void readFile(Hashtable<Integer, Student> stuHT) {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false; // to indicate the end of the file
			boolean DEBUG = false; // switch for output
			int lineNum = 0; // to hold the line count
			while (!eof && lineNum < 41) { // while the end of file is not reached and it reads no more than 40 students
				String line = buff.readLine(); // read one line from the file
				lineNum++; // increment the line number
				if (line == null) // if the file is empty we are at the end of the file
					eof = true;
				else if (lineNum == 1) // if we are at the first line there is no data we have to read there
				{
					if (DEBUG)
						System.out.println(line);
				} else { // the line has data we need
					int quiz[] = new int[5]; // to hold the quiz scores
					Integer id = null; // to hold the student id number
					if (DEBUG)
						System.out.println(line);
					StringTokenizer st = new StringTokenizer(line);
					while (st.hasMoreTokens()) { // while there are more quizzes to read
						id = Integer.parseInt(st.nextToken()); // parse the quizzes into integers and store in val
						for (int i = 0; i < quiz.length; i++)
							quiz[i] = Integer.parseInt(st.nextToken());
					}
					Student s = new Student(id, quiz);
					stuHT.put(id, s);
				}
			}
			buff.close(); // closes the buffer
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}