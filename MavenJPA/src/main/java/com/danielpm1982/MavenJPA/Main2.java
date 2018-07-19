package com.danielpm1982.MavenJPA;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//This is the same Main of this package, but with EntityManagerFactory and EntityManager JPA implementation.

public class Main2 {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DAO_SessionPU");
	public static void main(String[] args) {
		try {
			testTruncateTable(); System.out.println();
			testDAO2Insert(); System.out.println();
			testDAO2Search1(); System.out.println();
			testDAO2Search2(); System.out.println();
			testDAO2Search3(); System.out.println();
			testDAO2Search4(); System.out.println();
			testDAO2Update1(); System.out.println();
			testDAO2Update2(); System.out.println();
			testDAO2Update3(); testDAO2Search4(); System.out.println();
			testDAO2Delete1(); System.out.println();
			testDAO2Delete2(); System.out.println();
			testDAO2Delete3(); System.out.println();
			testDAO2Delete4(); System.out.println();
			testDAO2Delete5(); System.out.println();
			testDAO2Search4(); System.out.println();
			testTruncateTable();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			factory.close();
		}
	}
	private static void testDAO2Insert() {
		Student student = new Student("student1");
		System.out.println("Inserting unmanaged "+student);
		boolean result = DAO2.insertStudent(student, factory);
		if(result) {
			System.out.print("Insertion successful! Student now in managed state: ");
			System.out.println(student);
		}
		
		Student student2 = new Student("student2");
		System.out.println("Inserting unmanaged "+student2);
		boolean result2 = DAO2.insertStudent(student2, factory);
		if(result2) {
			System.out.print("Insertion successfully! Student now in managed state: ");
			System.out.println(student2);
		}
		
		Student student3 = new Student("student3");
		System.out.println("Inserting unmanaged "+student3);
		boolean result3 = DAO2.insertStudent(student3, factory);
		if(result3) {
			System.out.print("Insertion successfully! Student now in managed state: ");
			System.out.println(student3);
		}
	}
	private static void testDAO2Search1() {
		Long studentId = 1L;
		System.out.println("Searching unmanaged existent student. Id="+studentId+".");
		Student student = DAO2.searchStudent(studentId, factory);
		if(student!=null) {
			System.out.print("Student found! And is now in managed state: ");
			System.out.println(student);
		} else {
			System.out.println("Student not found!");
		}
		
		Long studentId2 = 2L;
		System.out.println("Searching unmanaged existent student. Id="+studentId2+".");
		Student student2 = DAO2.searchStudent(studentId2, factory);
		if(student2!=null) {
			System.out.print("Student found! And is now in managed state: ");
			System.out.println(student2);
		} else {
			System.out.println("Student not found!");
		}
	}
	private static void testDAO2Search2() {
		Long studentId = 1000L;
		System.out.println("Searching unmanaged inexistent student. Id="+studentId+".");
		Student student = DAO2.searchStudent(studentId, factory);
		if(student!=null) {
			System.out.print("Student found! And is now in managed state: ");
			System.out.println(student);
		} else {
			System.out.println("Student not found!");
		}
	}
	private static void testDAO2Search3() {
		String studentName = "ude";
		System.out.println("Searching ALL students with partial or total names = '"+studentName+"'.");
		List<Student> studentList = DAO2.searchStudents(studentName, factory);
		if(studentList!=null&&studentList.size()>0) {
			System.out.println("Student(s) found ("+studentList.size()+")!");
			studentList.forEach(System.out::println);
		} else {
			System.out.println("No Student found for that name!");
		}
	}
	private static void testDAO2Search4() {
		System.out.println("Searching ALL students in the DB.");
		List<Student> studentList = DAO2.searchAllStudents(factory);
		if(studentList!=null&&studentList.size()>0) {
			System.out.println("Student(s) found ("+studentList.size()+")!");
			studentList.forEach(System.out::println);
		} else {
			System.out.println("No Student(s) found in the DB!");
		}
	}
	private static void testDAO2Update1() {
		Student mockOldStudent = new Student("doesn't matter the other attributes, only the id!"); mockOldStudent.setId(3L);
		Student mockNewStudent = new Student("student300");
		System.out.println("Updating existing student registry from reference="+mockOldStudent+" to "+mockNewStudent+".");
		boolean result = DAO2.updateStudent(mockOldStudent, mockNewStudent,factory);
		if(result) {
			System.out.println("Student found and updated!");
		} else {
			System.out.println("Target Student entity does not exist in the DB! Get a valid Id, and try again!");
		}
	}
	private static void testDAO2Update2() {
		Student mockOldStudent = new Student("doesn't matter the other attributes, only the id!"); mockOldStudent.setId(30000000L);
		Student mockNewStudent = new Student("student600");
		System.out.println("Updating non-existing student registry from reference="+mockOldStudent+" to "+mockNewStudent+".");
		boolean result = DAO2.updateStudent(mockOldStudent, mockNewStudent,factory);
		if(result) {
			System.out.println("Student found and updated!");
		} else {
			System.out.println("Target Student entity does not exist in the DB! Get a valid Id, and try again!");
		}
	}
	private static void testDAO2Update3() {
		String oldName = "t1";
		String newName = "noOne";
		System.out.println("Updating existing student registries of partial or total name '"+oldName+"' to '"+newName+"'.");
		int affectedRows = DAO2.updateStudentBulk(oldName, newName, factory);
		if(affectedRows>0) {
			System.out.println("Student(s) found and updated ("+affectedRows+")!");
		} else {
			System.out.println("Target Student entity(ies) does(do) not exist in the DB! Get a valid name, and try again!");
		}
	}
	private static void testDAO2Delete1() {
		Long studentId = 1L;
		System.out.println("Deleting existing student registry from Id="+studentId+".");
		boolean result = DAO2.deleteStudent(studentId, factory);
		if(result) {
			System.out.println("Student found and deleted!");
		} else {
			System.out.println("Student entity does not exist in the DB! Get a valid Id, and try again!");
		}
	}
	private static void testDAO2Delete2() {
		Long studentId = 1000000L;
		System.out.println("Deleting inexisting student registry from Id="+studentId+".");
		boolean result = DAO2.deleteStudent(studentId, factory);
		if(result) {
			System.out.println("Student found and deleted!");
		} else {
			System.out.println("Student entity does not exist in the DB! Get a valid Id, and try again!");
		}
	}
	private static void testDAO2Delete3() {
		Student student = new Student("doesn't matter the other attributes, only the id!"); student.setId(20000000L);
		System.out.println("Deleting non-existing student registry from reference="+student+".");
		boolean result = DAO2.deleteStudent(student, factory);
		if(result) {
			System.out.println("Student found and deleted!");
		} else {
			System.out.println("Student entity does not exist in the DB! Get a valid Id, and try again!");
		}
	}
	private static void testDAO2Delete4() {
		Student student = new Student("doesn't matter the other attributes, only the id!"); student.setId(2L);
		System.out.println("Deleting existing student registry from reference="+student+".");
		boolean result = DAO2.deleteStudent(student, factory);
		if(result) {
			System.out.println("Student found and deleted!");
		} else {
			System.out.println("Student entity does not exist in the DB! Get a valid Id, and try again!");
		}
	}
	private static void testDAO2Delete5() {
		String studentName = "";
		System.out.println("Deleting existing student registries with name='"+studentName+"'.");
		boolean result = DAO2.deleteStudentBulk(studentName, factory);
		if(result) {
			System.out.println("Student(s) found and deleted!");
		} else {
			System.out.println("No Student(s) found for that name!");
		}
	}
	private static void testTruncateTable() {
		String fullyQualifiedTableName="scheme1.student";
		boolean result = DAO2.truncateDBTable(fullyQualifiedTableName, factory);
		if(result) {
			System.out.println("Table "+fullyQualifiedTableName+" truncated!");
		} else {
			System.out.println("Table "+fullyQualifiedTableName+" NOT truncated!");
		}
	}
}
