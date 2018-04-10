import adapter.*;

public class Driver8 {
	public static void main(String[] args) {
		// Test Instructor interface
		Creatable p = new GradeBook();
		String fname = "C:\\Users\\eneak\\Documents\\Java Playground\\Student Database\\src\\data";
		p.createGradeBook(fname);
		p.printGradeBook();

		p.printGrades(1234);
		// next three lines should give a compiler error - can you say why?
		// p.getStats();
		// p.printstudentscores(1234);
		// p.printstudentscores(9111); // invalid student id shld print a friendly
		// message - no such student.

		// Test Student Interface
		Printable s = (Printable) p;
		// s.printGradebook(); // Error
		System.out.printf("\n\n\n\n\n");
		s.getStats();
		System.out.printf("\n\n\n\n\n");
		s.printstudentscores(1234);
		System.out.printf("\n\n\n\n\n");
		s.printstudentscores(9111); // invalid student id shld print a friendly message
	}
}