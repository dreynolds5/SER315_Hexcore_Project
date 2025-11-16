public class Racer {
    private int racerId;
    private String racerName;
    private String racerEmail;
    private String password;
    private License racerLicense;

    public Racer(int racerId, String racerName, String racerEmail, String password) {
        this.racerId = racerId;
        this.racerName = racerName;
        this.racerEmail = racerEmail;
        this.password = password;
        racerLicense = new License(racerId, 3, "2025-05-17","2026-05-17");
    }

    public int getRacerId() {
        return racerId;
    }

    public void setRacerId(int racerId) {
        this.racerId = racerId;
    }

    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public String getRacerEmail() {
        return racerEmail;
    }

    public void setRacerEmail(String racerEmail) {
        this.racerEmail = racerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public License getRacerLicense() {
        return racerLicense;
    }

    public void setRacerLicense(License racerLicense) {
        this.racerLicense = racerLicense;
    }
}
