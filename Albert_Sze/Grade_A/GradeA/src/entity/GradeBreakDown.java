package entity;

public class GradeBreakDown implements Comparable<GradeBreakDown>{
	String cwName;
	String courseName;
	float typePercentage;
	float percentage;
	String type;
	int weight;
	int totalPoint;
	int pointLost;

	public GradeBreakDown(){

	}
	public GradeBreakDown(String name,String cname,float tpt,float p,String t,int w,int tt,int pl){
		cwName = name;
		courseName = cname;
		typePercentage = tpt;
		percentage = p;
		type = t;
		weight = w;
		totalPoint = tt;
		pointLost = pl;
	}
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCwName() {
		return cwName;
	}

	public void setCwName(String cwName) {
		this.cwName = cwName;
	}

	public float getTypePercentage() {
		return typePercentage;
	}

	public void setTypePercentage(float typePercentage) {
		this.typePercentage = typePercentage;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getPointLost() {
		return pointLost;
	}

	public void setPointLost(int pointLost) {
		this.pointLost = pointLost;
	}

	public GradeBreakDown(String cwName,int tp,int p,String t,int w,int totalPoint,int pl){
		this.cwName = cwName;
		typePercentage = tp;
		percentage = p;
		type = t;
		weight = w;
		this.totalPoint = totalPoint;
		pointLost = pl;

	}

	@Override
	public String toString() {
		return "GradeBreakDown{" +
				"cwName='" + cwName + '\'' +
				", courseName='" + courseName + '\'' +
				", typePercentage=" + typePercentage +
				", percentage=" + percentage +
				", type='" + type + '\'' +
				", weight=" + weight +
				", totalPoint=" + totalPoint +
				", pointLost=" + pointLost +
				'}';
	}

	@Override
	public int compareTo(GradeBreakDown o) {
		return cwName.compareTo(o.cwName);
	}
}
