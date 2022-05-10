package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Score {

	private List<ScoreInfo> studentsRecord = new ArrayList<>();
	
	private Function<ScoreInfo, Integer> mapScoreInfoToScore = (s) -> {
		return s.getScore();
	};

	public Score() {
		studentsRecord.add(new ScoreInfo("Smith", "John", 70));
		studentsRecord.add(new ScoreInfo("Doe", "Mary", 85));
		studentsRecord.add(new ScoreInfo("Page", "Alice", 82));
		studentsRecord.add(new ScoreInfo("Cooper", "Jill", 97));
		studentsRecord.add(new ScoreInfo("Flinstone", "Fred", 66));
		studentsRecord.add(new ScoreInfo("Rubble", "Barney", 80));
		studentsRecord.add(new ScoreInfo("Smith", "Judy", 48));
		studentsRecord.add(new ScoreInfo("Dean", "James", 90));
		studentsRecord.add(new ScoreInfo("Russ", "Joe", 55));
		studentsRecord.add(new ScoreInfo("Wolfe", "Bill", 73));
		studentsRecord.add(new ScoreInfo("Dart", "Mary", 54));
		studentsRecord.add(new ScoreInfo("Rogers", "Chris", 78));
		studentsRecord.add(new ScoreInfo("Toole", "Pat", 51));
		studentsRecord.add(new ScoreInfo("Khan", "Omar", 93));
		studentsRecord.add(new ScoreInfo("Smith", "Ann", 95));
	}


	public int getNumScores() {	
		return (int) studentsRecord.stream().count();
	}
	
	public float getAverage() {
		return (float) studentsRecord.stream().map(mapScoreInfoToScore).mapToInt(Integer::intValue).average().orElse(0);
	}
	
	public int getNumberAListers() {
		Predicate<ScoreInfo> filterAScores = (s) -> {
			if (s.getScore() >= 90) {
				return true;
			} else {
				return false;
			}
		};
		return (int) studentsRecord.stream().filter(filterAScores).count();
	}
	

	public List<ScoreInfo> getFailingStudentList() {
		Predicate<ScoreInfo> filterFailedScores = (s) -> {
			if (s.getScore() < 70) {
				return true;
			} else {
				return false;
			}
		};
		return studentsRecord.stream().filter(filterFailedScores).collect(Collectors.toList());
	}
	
	public void printPassingStudents() {
		Predicate<ScoreInfo> filterPassedScores = (s) -> {
			if (s.getScore() >= 70) {
				return true;
			} else {
				return false;
			}
		};
		System.out.println(studentsRecord.stream().filter(filterPassedScores).collect(Collectors.toList()).toString());
	}
	
	public void displayAllStudents() {
		Comparator<ScoreInfo> sortedLastName = (sx, sy) -> {
			if (sx.getLastName().compareTo(sy.getLastName()) == 0) {
				return 0;
			} else if (sx.getLastName().compareTo(sy.getLastName()) < 0) {
				return -2;
			} else {
				return 2;
			}
		};
		
		studentsRecord.stream().sorted(sortedLastName).collect(Collectors.toList()).
		forEach((s) -> System.out.println(String.join(" ", s.getFirstName(), 
				s.getLastName(), String.valueOf(s.getScore())))
				);
	}
	
	public List<String> getStudentRecords() {
		Comparator<ScoreInfo> sortedScore = (sx, sy) -> {
			if (sx.getScore() == (sy.getScore())) {
				return 0;
			} else if (sx.getScore() < (sy.getScore())) {
				return -2;
			} else {
				return 2;
			}
		};
		List<String> record = new ArrayList<>();
		studentsRecord.stream().sorted(sortedScore).collect(Collectors.toList()).forEach(
				(s) -> record.add(String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore())))
				);
		return record;
	}
	
}

class ScoreInfo {

	private String firstName;
	private String lastName;
	private int score;
	
	public ScoreInfo() {

	}
	
	public ScoreInfo(String lName, String fName, int s) {
		this.firstName = fName;
		this.lastName = lName;
		this.score = s;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.join(" ", lastName, firstName, String.valueOf(score));
	}
	
}
