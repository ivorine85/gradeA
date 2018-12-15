package entity;

public class Assignment implements Comparable<Assignment>{
	private String type;
	private String cwname;
	private int totalPts;
	private float gradPercentage;
	private float gradTypePercentage;
	private float undergradPercentage;
	private float undergradTypePercentage;
	private int weight;
	private String courseName;

	public Assignment (String type, String name,int total,float gp,float gtp,float up,float utp,int w) {
		this.type = type;
		cwname = name;
		totalPts = total;
		gradPercentage = gp;
		gradTypePercentage = gtp;
		undergradPercentage = up;
		undergradTypePercentage = utp;
		weight = w;
	}

	public Assignment(String type,String name,int total,float gp,float up,String cname){
		this.type = type;
		cwname = name;
		totalPts = total;
		gradPercentage = gp;
		undergradPercentage = up;
		weight = 0;
		courseName = cname;
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

	public float getGradPercentage() {
		return gradPercentage;
	}

	public void setGradPercentage(float gradPercentage) {
		this.gradPercentage = gradPercentage;
	}

	public float getGradTypePercentage() {
		return gradTypePercentage;
	}

	public void setGradTypePercentage(float gradTypePercentage) {
		this.gradTypePercentage = gradTypePercentage;
	}

	public float getUndergradPercentage() {
		return undergradPercentage;
	}

	public void setUndergradPercentage(float undergradPercentage) {
		this.undergradPercentage = undergradPercentage;
	}

	public float getUndergradTypePercentage() {
		return undergradTypePercentage;
	}

	public void setUndergradTypePercentage(float undergradTypePercentage) {
		this.undergradTypePercentage = undergradTypePercentage;
	}

	@Override
	public String toString(){
		return "type "+type+" cwname:"+cwname+" total:"+totalPts+" gradP:"+gradPercentage +" gradTP:"+gradTypePercentage+
				" up:"+undergradPercentage+" utp:"+undergradTypePercentage;
	}

	@Override
	public int compareTo(Assignment o) {
		return cwname.compareTo(o.cwname);
	}
}
