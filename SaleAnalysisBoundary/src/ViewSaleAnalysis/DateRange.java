package ViewSaleAnalysis;
import java.util.*;
class DateRange {
    private Date startDate;
    private Date endDate;

    public DateRange(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isWithinRange(Date date) {
        return (date.equals(startDate) || date.after(startDate)) && (date.equals(endDate) || date.before(endDate));
    }
}