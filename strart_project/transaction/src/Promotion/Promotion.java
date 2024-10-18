package Promotion;

import java.time.LocalDate;
import java.util.Date;

public class Promotion {
    private int promotionID;
    private String promotionType;
    private String promotionName;
    private String description;
    private double  discountRate;
    private Date startDate;
    private Date endDate;
    
    public Promotion(int promotonID, String promotionType, String promotionName, String description, double discountrate, Date startDate, Date endDate){
        this.promotionID = promotonID;
        this.promotionType = promotionType;
        this.promotionName = promotionName;
        this.discountRate = discountrate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Promotion(int promotionID, String promotionType, String promotionName, String promoDetails, double discountRate, LocalDate startDate, LocalDate endDate) {

    }

    public interface PromotionListener{
        void onPromotionCreated(Promotion newPromotion);
    }
    
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
    public void setPromotionType(String promotionType){
        this.promotionType = promotionType;
    }

    public int getPromotionID(){
        return this.promotionID;
    }
    public String getPromotionName(){
        return this.promotionName;
    }
    public double getDiscountRate(){
        return this.discountRate;
    }
    public Date getStartDate(){
        return this.startDate;
    }
    public Date getEndDate(){
        return this.endDate;
    }
    public String getPromotionType(){
        return this.promotionType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
