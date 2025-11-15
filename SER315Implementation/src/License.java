public class License {
    private int licenseID;
    private int licenseCategory;
    private String issueDate;
    private String expiryDate;

    public License(int id, int category, String issueDate, String expiryDate) {
        licenseID = id;
        licenseCategory = category;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired(String date) {
        return expiryDate.compareTo(date) <= 0;
    }

    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    public int getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(int licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
