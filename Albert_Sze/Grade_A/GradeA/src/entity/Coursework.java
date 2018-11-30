package entity;

public class Coursework {
	private String type;
	private String cwname;
	private int totalPts;
	private int gradPercentage;
	private int gradTypePercentage;
	private int undergradPercentage;
	private int undergradTypePercentage;
	private int weight;
	
	public Coursework (String type, String name,int total,int gp,int gtp,int up,int utp,int w) {
		this.type = type;
		cwname = name;
		totalPts = total;
		gradPercentage = gp;
		gradTypePercentage = gtp;
		undergradPercentage = up;
		undergradTypePercentage = utp;
		weight = w;
	}

/*********************************** Getters and Setters ***********************************/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCwname() {
		return cwname;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setCwname(String cwname) {
		this.cwname = cwname;

	}

	public int getTotalPts() {
		return totalPts;
	}

	public void setTotalPts(int totalPts) {
		this.totalPts = totalPts;
	}

	public int getGradPercentage() {
		return gradPercentage;
	}

	public void setGradPercentage(int gradPercentage) {
		this.gradPercentage = gradPercentage;
	}

	public int getGradTypePercentage() {
		return gradTypePercentage;
	}

	public void setGradTypePercentage(int gradTypePercentage) {
		this.gradTypePercentage = gradTypePercentage;
	}

	public int getUndergradPercentage() {
		return undergradPercentage;
	}

	public void setUndergradPercentage(int undergradPercentage) {
		this.undergradPercentage = undergradPercentage;
	}

	public int getUndergradTypePercentage() {
		return undergradTypePercentage;
	}

	public void setUndergradTypePercentage(int undergradTypePercentage) {
		this.undergradTypePercentage = undergradTypePercentage;
	}
}
