package assignment7;

public class Student {

	private String firstName;
	private String lastName;
	private int studID;
	private int attemptedCred;
	private int passingCred;
	private double totalGradeQualPts;
	private double bbBalance;

	public Student(String first, String last, int id) {
		firstName = first;
		lastName = last;
		studID = id;

	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public int getId() {
		return studID;
	}

	public void submitGrade(double grade, int credits) {
		attemptedCred = attemptedCred + credits;
		if (grade > 1.7) {
			passingCred = passingCred + credits;
		}
		double gradePts = credits * grade;
		totalGradeQualPts = totalGradeQualPts + gradePts;
	}

	public int getTotalAttemptedCredits() {
		return attemptedCred;
	}

	public int getTotalPassingCredits() {
		return passingCred;
	}

	public double calculateGradePointAverage() {
		double GPA = (double) totalGradeQualPts / attemptedCred;
		return GPA;
	}

	public String getClassStanding() {
		if (passingCred < 30) {
			return "First Year";
		} else if (passingCred >= 30 && passingCred < 60) {
			return "Sophomore";
		} else if (passingCred >= 60 && passingCred < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}

	public boolean isEligibleForPhiBetaKappa() {
		if (passingCred >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		} else if (passingCred >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		} else {
			return false;
		}
	}

	public void depositBearBucks(double amount) {
		bbBalance = bbBalance + amount;

	}

	public void deductBearBucks(double amount) {
		bbBalance = bbBalance - amount;

	}

	public double getBearBucksBalance() {
		return bbBalance;
	}

	public double cashOutBearBucks() {
		double remainingBB = bbBalance;
		bbBalance = 0;
		if (remainingBB <= 10) {
			return 0;
		} else {
			return remainingBB - 10;
		}
	}

	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		if (isHyphenated) {
			Student leg = new Student(firstName, this.lastName + "-" + other.lastName, id);
			leg.bbBalance = this.cashOutBearBucks() + other.cashOutBearBucks();
			return leg;
		} else {
			Student leg = new Student(firstName, this.lastName, id);
			leg.bbBalance = this.cashOutBearBucks() + other.cashOutBearBucks();
			return leg;
		}
	}

	public String toString() {
		return firstName + " " + lastName + " id: " + studID;
	}

}
