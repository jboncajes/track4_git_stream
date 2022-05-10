package org.ssglobal.training.codes;

public class TestScore {

	public static void main(String[] args) {
		Score score = new Score();
		System.out.println("Number of students:");
		System.out.println(score.getNumScores());
		System.out.println("Average score of all students:");
		System.out.println(score.getAverage());
		System.out.println("Number of students with A:");
		System.out.println(score.getNumberAListers());
		System.out.println("Failed students:");
		System.out.println(score.getFailingStudentList().toString());
		System.out.println("Passed students:");
		score.printPassingStudents();
		System.out.println("Students list last name based:");
		score.displayAllStudents();
		System.out.println("Students list score based:");
		System.out.println(score.getStudentRecords());
		
	}

}
