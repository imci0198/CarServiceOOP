package Domain;

public class ClientEntry {
    private int idClientEntry;
    private int standNumber;
    private String licensePlate;
    private int numberOfDays;
    private boolean leftService;
    private double billedPrice;
    private String report;

    public ClientEntry(int idClientEntry, int standNumber, String licensePlate, int numberOfDays) {
        this.idClientEntry = idClientEntry;
        this.standNumber = standNumber;
        this.licensePlate = licensePlate;
        this.numberOfDays = numberOfDays;
        this.leftService = false;
    }

    public int getIdClientEntry() {
        return idClientEntry;
    }

    public int getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(int standNumber) {
        this.standNumber = standNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isLeftService() {
        return leftService;
    }

    public void setLeftService(boolean leftService) {
        this.leftService = leftService;
    }

    public double getBilledPrice() {return billedPrice;}

    public void setBilledPrice(double billedPrice) {
        this.billedPrice = billedPrice;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "ClientEntry{" +
                "idClientEntry=" + idClientEntry +
                ", standNumber=" + standNumber +
                ", licensePlate='" + licensePlate + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", leftService=" + leftService +
                ", billedPrice=" + billedPrice+
                ", report=" + report+
                '}';
    }
}
