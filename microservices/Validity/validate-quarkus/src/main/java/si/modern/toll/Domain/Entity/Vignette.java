package si.modern.toll.Domain.Entity;

import java.util.Date;

public class Vignette {
    public enum DurationType {
        weekly, monthly, semiAnnual, annual
    }

    public enum VehicleType {
        one, twoA, twoB
    }

    private String numberPlate;
    private Date dateFrom;
    private Date dateTo;
    private Date datePurchased;
    private String locationPurchased;
    private DurationType durationType;
    private VehicleType vehicleType;

    public Vignette() {
    }

    public Vignette(String numberPlate, Date dateFrom, Date dateTo, Date datePurchased, String locationPurchased, DurationType durationType, VehicleType vehicleType) {
        this.numberPlate = numberPlate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.datePurchased = datePurchased;
        this.locationPurchased = locationPurchased;
        this.durationType = durationType;
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    public String getLocationPurchased() {
        return locationPurchased;
    }

    public void setLocationPurchased(String locationPurchased) {
        this.locationPurchased = locationPurchased;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vignette{" +
                "numberPlate='" + numberPlate + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", datePurchased=" + datePurchased +
                ", locationPurchased='" + locationPurchased + '\'' +
                ", durationType=" + durationType +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
