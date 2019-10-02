package helper;

import java.time.LocalDate;

public class DateThing {
    private LocalDate theDate;
    private String year = "0000";
    private String month = "00";
    private String day = "00";

    public DateThing(LocalDate theDate) {
        super();
        this.theDate = theDate;
        fixDateFields();
    }

    private void fixDateFields() {
        if (theDate != null) {
            year = String.valueOf(theDate.getYear());
            month = String.valueOf(theDate.getMonthValue());
            day = String.valueOf(theDate.getDayOfMonth());
        }
    }

    public LocalDate getDob() {
        return theDate;
    }

    public void setDob(LocalDate theDate) {
        this.theDate = theDate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }   
    
    
}
