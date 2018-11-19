package Entity;

import Entity.Assignment;

public class Project extends Assignment {
	private int ptsLostReport;
	private int ptsLostPresentation;
	private int ptsLostTechnical;
	private int ptsLostSurvey;

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
	
	public int getPtsLostSurvey() {
		return ptsLostSurvey;
	}

	public void setPtsLostSurvey(int ptsLostSurvey) {
		this.ptsLostSurvey = ptsLostSurvey;
	}

	public Project() {
		super();
		this.ptsLostReport = 0;
		this.ptsLostPresentation = 0;
		this.ptsLostTechnical = 0;
		this.ptsLostSurvey = 0;
	}
	
	public Project(String type, int ptsLostPresentation, int ptsLostReport, int ptsLostTechnical,int ptsLostSurvey, int totalPts) {
		super(type, ptsLostReport+ptsLostPresentation+ptsLostTechnical+ptsLostSurvey, totalPts, 0);
		this.ptsLostReport = ptsLostReport;
		this.ptsLostPresentation = ptsLostPresentation;
		this.ptsLostTechnical = ptsLostTechnical;
		this.ptsLostSurvey = ptsLostSurvey;
	}
}
