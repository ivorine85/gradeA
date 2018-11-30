package entity;

public class studentGradeRecord {
    String cwName;
    int typePercentage;
    int percentage;
    String type;
    int weight;
    int totalPoint;
    int pointLost;

    public String getCwName() {
        return cwName;
    }

    public void setCwName(String cwName) {
        this.cwName = cwName;
    }

    public int getTypePercentage() {
        return typePercentage;
    }

    public void setTypePercentage(int typePercentage) {
        this.typePercentage = typePercentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
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

    public studentGradeRecord(String cwName,int tp,int p,String t,int w,int totalPoint,int pl){
        this.cwName = cwName;
        typePercentage = tp;
        percentage = p;
        type = t;
        weight = w;
        this.totalPoint = totalPoint;
        pointLost = pl;
    }
}
