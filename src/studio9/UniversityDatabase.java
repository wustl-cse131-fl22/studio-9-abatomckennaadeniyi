package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> database;

	public UniversityDatabase() {
		database = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	public int getStudentCount() {
		int counter = 0;
		for (String account : database.keySet()) {
			counter++;
		}
		return counter;
	}

	public String lookupFullName(String accountName) {
		if (database.get(accountName) == null) {
			return null;
		} else {
			return (database.get(accountName)).getFullName();
		}

	}

	public double getTotalBearBucks() {
		double total = 0;
		for (String accountName : database.keySet()) {
			total = total + database.get(accountName).getBearBucksBalance();

		}
		return total;
	}
}
