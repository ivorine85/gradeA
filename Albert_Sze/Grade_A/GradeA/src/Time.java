
public class Time {
	public String hour;
	public String min;
	public String sec;
	public boolean am;
	
	public Time() {
		this.hour = "00";
		this.min = "00";
		this.sec = "00";
		this.am = true;
	}
	
	public Time(String hour,String min,String sec, boolean am) {
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		this.am = am;
	}
}