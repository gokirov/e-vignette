package si.modern.toll.Domain.Entity;

import java.util.Date;

public class Validity {
    private String numberPlate;
    private Date dateFrom;
    private Date dateTo;
    private Date dateChecked;
    private Boolean isValid;
    private Integer daysRemained;

    public Validity() {
    }

    public Validity(String numberPlate, Date dateFrom, Date dateTo, Date dateChecked, Boolean isValid, Integer daysRemained) {
        this.numberPlate = numberPlate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.dateChecked = dateChecked;
        this.isValid = isValid;
        this.daysRemained = daysRemained;
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

    public Date getDateChecked() {
        return dateChecked;
    }

    public void setDateChecked(Date dateChecked) {
        this.dateChecked = dateChecked;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Integer getDaysRemained() {
        return daysRemained;
    }

    public void setDaysRemained(Integer daysRemained) {
        this.daysRemained = daysRemained;
    }

    @Override
    public String toString() {
        return "Validity{" +
                "numberPlate='" + numberPlate + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", dateChecked=" + dateChecked +
                ", isValid=" + isValid +
                ", daysRemained=" + daysRemained +
                '}';
    }
}
