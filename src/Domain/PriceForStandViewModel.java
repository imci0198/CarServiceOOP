package Domain;

public class PriceForStandViewModel {
    private int standNumber;
    private double averagePriceForStand;

    public PriceForStandViewModel(int standNumber, double averagePriceForStand) {
        this.standNumber = standNumber;
        this.averagePriceForStand = averagePriceForStand;
    }

    public int getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(int standNumber) {
        this.standNumber = standNumber;
    }

    public double getAveragePriceForStand() {
        return averagePriceForStand;
    }

    public void setAveragePriceForStand(double averagePriceForStand) {
        this.averagePriceForStand = averagePriceForStand;
    }

    @Override
    public String toString() {
        return "PriceForStandViewModel{" +
                "standNumber=" + standNumber +
                ", averagePriceForStand=" + averagePriceForStand +
                '}';
    }
}
