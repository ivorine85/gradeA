
public class Assignment {
	private String type;
	private int ptsLost;
	private int totalPts;
	private double percent;
	private int weight;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Assignment () {
		this.type = "None";
		this.ptsLost = 0;
		this.totalPts = 0;
		this.percent = 0;
		this.weight = 0;	
	}
	
	public Assignment (String type, int ptsLost, int totalPts, int weight) {
		this.type = type;
		this.ptsLost = 0;
		this.totalPts = 0;
		this.percent = (totalPts-ptsLost)/(double)(totalPts);
		this.weight = 0;	
	}
}
