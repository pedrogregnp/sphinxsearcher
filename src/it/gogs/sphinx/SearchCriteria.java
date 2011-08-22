package it.gogs.sphinx;

public class SearchCriteria {

	public SearchCriteria() {
	}

	private String keywords;
	private DateRange dateRange;

	public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
