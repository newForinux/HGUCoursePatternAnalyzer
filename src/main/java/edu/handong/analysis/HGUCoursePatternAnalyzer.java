package edu.handong.analysis;

import edu.handong.analysis.datamodel.*;


public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			if (student != null)
				System.out.println (student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			if (course != null)
				System.out.println (course.getCourseName());
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		String[] temp = new String [lines.length];
		Student[] return_result = new Student [lines.length];
		int index = 0;
		
		for (int i = 0; i < lines.length; i++) {
			temp[i] = lines[i].split(",")[1];
		}
		
		for (int i = 0; i < lines.length; i++) {
			Student result = new Student(temp[i].trim());
			if (!studentExist(return_result, result)) {
				return_result[index] = result;
				index++;
			}
		}
		
		return return_result;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		for (int i = 0; students[i] != null; i++) {
			if (students[i].getName().equals(student.getName()))
				return true;
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		String[] temp = new String [lines.length];
		Course[] return_result = new Course [lines.length];
		int index = 0;
		
		for (int i = 0; i < lines.length; i++) {
			temp[i] = lines[i].split(",")[2];
		}
		
		for (int i = 0; i < temp.length; i++) {
			Course result = new Course(temp[i].trim());
			if (!courseExist(return_result, result)) {
				return_result[index] = result;
				index++;
			}
		}
		return return_result;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		// TODO: implement this method
		for (int i = 0; courses[i] != null; i++) {
			if (courses[i].getCourseName().equals(course.getCourseName()))
				return true;
		}
		return false;
	}
}