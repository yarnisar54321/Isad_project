package Promotion;

import java.util.Date;

public class Promotion {
    private int promotionID;
    private String promotionType;
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
    public void setPromotion(String promotionType){
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
    public String getPromotion(){
        return this.promotionType;
    }
}
