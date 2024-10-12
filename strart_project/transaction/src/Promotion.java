
import java.util.Date;

public class Promotion {
    private int promotionID;
    private String promotionName;
    private double  discountRate;
    private Date startDate;
    private Date endDate;
    
    public void setPromotionID(int promotionID){
        this.promotionID = promotionID;
    }
    public void setPromottionName(String promotionName){
        this.promotionName = promotionName;
    }
    public void setDiscountRate(double discountRate){
        this.discountRate = discountRate;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
}
