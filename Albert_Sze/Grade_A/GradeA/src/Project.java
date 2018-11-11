
public class Project extends Assignment {
	private int ptsLostReport;
	private int ptsLostPresentation;
	private int ptsLostTechnical;

	public int getPtsLostReport() {
		return ptsLostReport;
	}

	public void setPtsLostReport(int ptsLostReport) {
		this.ptsLostReport = ptsLostReport;
	}

	public int getPtsLostPresentation() {
		return ptsLostPresentation;
	}

	public void setPtsLostPresentation(int ptsLostPresentation) {
		this.ptsLostPresentation = ptsLostPresentation;
	}

	public int getPtsLostTechnical() {
		return ptsLostTechnical;
	}

	public void setPtsLostTechnical(int ptsLostTechnical) {
		this.ptsLostTechnical = ptsLostTechnical;
	}

	public Project() {
		this.ptsLostReport = 0;
		this.ptsLostPresentation = 0;
		this.ptsLostTechnical = 0;
	}
	
	public Project(int ptsLostReport, int ptsLostPresentation, int ptsLostTechnical) {
		this.ptsLostReport = ptsLostReport;
		this.ptsLostPresentation = ptsLostPresentation;
		this.ptsLostTechnical = ptsLostTechnical;
	}
}
