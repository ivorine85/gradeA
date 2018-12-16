package entity;

public abstract class Calculations {
	protected static double Calcaverage(double average, double assignment, int numitems) {
		return (((average*numitems)+assignment)/(double)(numitems+1));
	}
	
//	protected static double Calcfinalgrade(double grade,double score, double assignmentpercent) {
//		return (grade + (score*assignmentpercent));
//		// score for in individual assignment is equal to assignScore = ((assignmentTotalPts-assignmentPtsLost+assignmentWeight)/assignmentTotalPts)
//		// score for a category is categoryScore = sum(assignScore)
//	}

}
