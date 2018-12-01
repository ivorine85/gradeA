package entity;

public class Assignment {
	private String type;
	private String cwName;
	private int ptsLost;
	private int totalPts;
	private double percent;
	private double typePercentage;
	private int weight;
	
	public Assignment () {
		this.type = "None";
		this.ptsLost = 0;
		this.totalPts = 0;
		this.percent = 0;
		this.weight = 0;	
	}
	
	public Assignment (String type, int ptsLost, int totalPts, int weight) {
		this.type = type;
		this.ptsLost = ptsLost;
		this.totalPts = totalPts;
		this.percent = (totalPts-ptsLost)/(double)(totalPts);
		this.weight = weight;	
	}

/*********************************** Getters and Setters ***********************************/
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getCwName() {
		return cwName;
	}

	public void setCwName(String cwName) {
		this.cwName = cwName;
	}

	public int getPtsLost() {
		return ptsLost;
	}

	public void setPtsLost(int ptsLost) {
		this.ptsLost = ptsLost;
	}

	public int getTotalPts() {
		return totalPts;
	}

	public void setTotalPts(int totalPts) {
		this.totalPts = totalPts;
	}

	public double getTypePercentage() {
		return typePercentage;
	}

	public void setTypePercentage(double typePercentage) {
		this.typePercentage = typePercentage;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
